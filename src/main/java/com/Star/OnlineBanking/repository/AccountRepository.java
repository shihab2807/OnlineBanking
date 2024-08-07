package com.Star.OnlineBanking.repository;


import com.Star.OnlineBanking.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}

