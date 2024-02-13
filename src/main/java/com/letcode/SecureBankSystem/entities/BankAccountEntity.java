package com.letcode.SecureBankSystem.entities;

import javax.persistence.*;

@Entity
@Table(name = "bank_account")
public class BankAccountEntity {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "balance", nullable = false)
    private double balance;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;
}


