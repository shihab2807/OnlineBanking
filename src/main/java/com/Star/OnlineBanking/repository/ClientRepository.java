package com.Star.OnlineBanking.repository;

import com.Star.OnlineBanking.entity.Client;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.Optional;

public interface ClientRepository extends JpaRepository<Client, Long> {
    Optional<Client> findByUsername(String username);

	Page<Client> findByCriteria(LocalDate dateOfBirth, String phone, String name, String email, PageRequest of);
}
