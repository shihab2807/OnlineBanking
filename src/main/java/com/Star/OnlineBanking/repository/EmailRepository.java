package com.Star.OnlineBanking.repository;

import com.Star.OnlineBanking.entity.Email;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmailRepository extends JpaRepository<Email, Long> {
}

