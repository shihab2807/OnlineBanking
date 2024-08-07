package com.Star.OnlineBanking.service;



import com.Star.OnlineBanking.entity.Client;
import com.Star.OnlineBanking.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class SearchService {

    @Autowired
    private ClientRepository clientRepository;

    public Page<Client> searchClients(LocalDate dateOfBirth, String phone, String name, String email, int page, int size) {
        Pageable pageable = PageRequest.of(page, size);
        Specification<Client> spec = Specification.where(null);

        if (dateOfBirth != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.greaterThanOrEqualTo(root.get("dateOfBirth"), dateOfBirth));
        }
        if (phone != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("phones").get("phoneNumber"), phone));
        }
        if (name != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("name"), name + "%"));
        }
        if (email != null) {
            spec = spec.and((root, query, criteriaBuilder) -> criteriaBuilder.equal(root.join("emails").get("emailAddress"), email));
        }

        return clientRepository.findAll(pageable);
    }
}

