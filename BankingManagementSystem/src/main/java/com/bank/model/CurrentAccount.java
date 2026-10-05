package com.bank.model;

import java.math.BigDecimal;

public class CurrentAccount extends Account {
    private static final BigDecimal MINIMUM_BALANCE = new BigDecimal("5000.00");

    public CurrentAccount(String accountNumber, Customer customer, BigDecimal openingBalance) {
        super(accountNumber, customer, openingBalance);
    }

    @Override
    public String getAccountType() {
        return "CURRENT";
    }

    @Override
    public BigDecimal getMinimumBalance() {
        return MINIMUM_BALANCE;
    }
}
