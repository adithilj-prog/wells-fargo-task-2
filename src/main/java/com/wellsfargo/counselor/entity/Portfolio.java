package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;

@Entity
public class Portfolio {
    @Id
    @GeneratedValue()
    private long portfolioId;

    @OneToOne
    @JoinColumn(name = "client_id", nullable = false, unique = true)
    private Client client;

    @Column(nullable = false)
    private String riskLevel;

    @Column(nullable = false)
    private String baseCurrency;

    protected Portfolio() {}

    public Portfolio(Client client, String riskLevel, String baseCurrency) {
        this.client = client;
        this.riskLevel = riskLevel;
        this.baseCurrency = baseCurrency;
    }

    // Getters and setters
}

