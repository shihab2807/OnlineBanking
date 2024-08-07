package com.Star.OnlineBanking.service;


import  com.Star.OnlineBanking.entity.Client;
import  com.Star.OnlineBanking.entity.Email;
import com.Star.OnlineBanking.entity.Phone;
import com.Star.OnlineBanking.repository.ClientRepository;
import  com.Star.OnlineBanking.repository.EmailRepository;
import  com.Star.OnlineBanking.repository.PhoneRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.util.Optional;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private PhoneRepository phoneRepository;

    @Autowired
    private EmailRepository emailRepository;

    @Override
    public Client createClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Client findByUsername(String username) {
        return clientRepository.findByUsername(username).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    public Client updateClient(Client client) {
        return clientRepository.save(client);
    }

    @Override
    public Optional<Client> findById(Long id) {
        return clientRepository.findById(id);
    }

    @Override
    @Transactional
    public Client addPhone(Long clientId, Phone phone) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.getPhones().add(phone);
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updatePhone(Long clientId, Long phoneId, Phone newPhone) {
        Phone phone = phoneRepository.findById(phoneId).orElseThrow(() -> new RuntimeException("Phone not found"));
        phone.setPhoneNumber(newPhone.getPhoneNumber());
        phoneRepository.save(phone);
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    @Transactional
    public Client deletePhone(Long clientId, Long phoneId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Phone phone = phoneRepository.findById(phoneId).orElseThrow(() -> new RuntimeException("Phone not found"));
        if (client.getPhones().size() <= 1) {
            throw new RuntimeException("At least one phone number is required");
        }
        client.getPhones().remove(phone);
        phoneRepository.delete(phone);
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client addEmail(Long clientId, Email email) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        client.getEmails().add(email);
        return clientRepository.save(client);
    }

    @Override
    @Transactional
    public Client updateEmail(Long clientId, Long emailId, Email newEmail) {
        Email email = emailRepository.findById(emailId).orElseThrow(() -> new RuntimeException("Email not found"));
        email.setEmailAddress(newEmail.getEmailAddress());
        emailRepository.save(email);
        return clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
    }

    @Override
    @Transactional
    public Client deleteEmail(Long clientId, Long emailId) {
        Client client = clientRepository.findById(clientId).orElseThrow(() -> new RuntimeException("Client not found"));
        Email email = emailRepository.findById(emailId).orElseThrow(() -> new RuntimeException("Email not found"));
        if (client.getEmails().size() <= 1) {
            throw new RuntimeException("At least one email is required");
        }
        client.getEmails().remove(email);
        emailRepository.delete(email);
        return clientRepository.save(client);
    }

    @Override
    public Page<Client> searchClients(LocalDate dateOfBirth, String phone, String name, String email, int page, int size) {
        // Implement search logic here, possibly using a Specification or custom query method
        // For simplicity, assuming a method clientRepository.findByCriteria is available
        return clientRepository.findByCriteria(dateOfBirth, phone, name, email, PageRequest.of(page, size));
    }
}

