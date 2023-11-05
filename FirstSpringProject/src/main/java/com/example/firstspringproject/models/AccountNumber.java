package com.example.firstspringproject.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class AccountNumber {
    @Id
    private int number;

    public AccountNumber(){}

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
