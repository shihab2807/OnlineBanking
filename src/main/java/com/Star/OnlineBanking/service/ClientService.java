package com.Star.OnlineBanking.service;

import com.Star.OnlineBanking.entity.Client;
import com.Star.OnlineBanking.entity.Email;
import com.Star.OnlineBanking.entity.Phone;
import org.springframework.data.domain.Page;

import java.time.LocalDate;
import java.util.Optional;

public interface ClientService {
    Client createClient(Client client);
    Client findByUsername(String username);
    Client updateClient(Client client);

    Optional<Client> findById(Long id);

    Client addPhone(Long clientId, Phone phone);
    Client updatePhone(Long clientId, Long phoneId, Phone newPhone);
    Client deletePhone(Long clientId, Long phoneId);

    Client addEmail(Long clientId, Email email);
    Client updateEmail(Long clientId, Long emailId, Email newEmail);
    Client deleteEmail(Long clientId, Long emailId);

    Page<Client> searchClients(LocalDate dateOfBirth, String phone, String name, String email, int page, int size);
}


