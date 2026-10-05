package com.bank.model;

import java.math.BigDecimal;

public class SavingsAccount extends Account {
    private static final BigDecimal MINIMUM_BALANCE = new BigDecimal("1000.00");
    private static final BigDecimal INTEREST_RATE = new BigDecimal("0.04");

    public SavingsAccount(String accountNumber, Customer customer, BigDecimal openingBalance) {
        super(accountNumber, customer, openingBalance);
    }

    @Override
    public String getAccountType() {
        return "SAVINGS";
    }

    @Override
    public BigDecimal getMinimumBalance() {
        return MINIMUM_BALANCE;
    }

    public BigDecimal calculateAnnualInterest() {
        return getBalance().multiply(INTEREST_RATE);
    }
}
