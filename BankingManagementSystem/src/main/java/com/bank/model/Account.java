package com.bank.model;

import com.bank.exception.InsufficientBalanceException;
import com.bank.exception.InvalidAmountException;

import java.math.BigDecimal;

public abstract class Account {

    private final String accountNumber;
    private final Customer customer;
    private BigDecimal balance;
    private boolean active;

    protected Account(String accountNumber,
                      Customer customer,
                      BigDecimal openingBalance) {

        if (openingBalance == null ||
                openingBalance.compareTo(BigDecimal.ZERO) < 0) {

            throw new InvalidAmountException(
                    "Opening balance cannot be negative."
            );
        }

        this.accountNumber = accountNumber;
        this.customer = customer;
        this.balance = openingBalance;
        this.active = true;
    }

    public abstract String getAccountType();

    public abstract BigDecimal getMinimumBalance();

    public void deposit(BigDecimal amount) {

        validateAmount(amount);
        ensureActive();

        balance = balance.add(amount);
    }

    public void withdraw(BigDecimal amount) {

        validateAmount(amount);
        ensureActive();

        BigDecimal newBalance = balance.subtract(amount);

        if (newBalance.compareTo(getMinimumBalance()) < 0) {

            throw new InsufficientBalanceException(
                    "Withdrawal denied. Minimum balance requirement is ₹"
                            + getMinimumBalance()
            );
        }

        balance = newBalance;
    }

    protected void validateAmount(BigDecimal amount) {

        if (amount == null ||
                amount.compareTo(BigDecimal.ZERO) <= 0) {

            throw new InvalidAmountException(
                    "Amount must be greater than zero."
            );
        }
    }

    protected void ensureActive() {

        if (!active) {
            throw new IllegalStateException("Account is closed.");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public boolean isActive() {
        return active;
    }

    public void closeAccount() {
        active = false;
    }

    @Override
    public String toString() {

        return "Account{" +
                "accountNumber='" + accountNumber + '\'' +
                ", customer=" + customer.getName() +
                ", type=" + getAccountType() +
                ", balance=₹" + balance +
                ", active=" + active +
                '}';
    }
}