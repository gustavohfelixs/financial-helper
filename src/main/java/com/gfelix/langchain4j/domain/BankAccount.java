package com.gfelix.langchain4j.domain;

import java.math.BigDecimal;

public class BankAccount {
    private Long id;
    private BigDecimal balance;
    private String name;

    public BankAccount(Long id, String name, BigDecimal balance) {
        this.id = id;
        this.balance = balance;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}