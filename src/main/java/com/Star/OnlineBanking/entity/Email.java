package com.Star.OnlineBanking.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "emails")
public class Email {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String emailAddress;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;
}
