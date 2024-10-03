package com.taxi.uber.entities;

import com.taxi.uber.enums.TransactionMethod;
import com.taxi.uber.enums.TransactionType;
import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
public class WalletTransaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    @OneToOne
    private Ride ride;

    private String transactionId;

    @ManyToOne
    private  Wallet wallet  ;

    @CreationTimestamp
    private LocalDateTime timeStamp;
}
