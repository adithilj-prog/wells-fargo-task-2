package com.wellsfargo.counselor.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.JoinColumn;


@Entity
public class Client {

    @Id
    @GeneratedValue()
    private long clientId;

    @ManyToOne
    @JoinColumn(name = "advisor_id", nullable = false)
    private Advisor advisor;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String contactInfo;

    protected Client() {}

    public Client(Advisor advisor, String name, String contactInfo) {
        this.advisor = advisor;
        this.name = name;
        this.contactInfo = contactInfo;
    }

    // Getters and setters
}

