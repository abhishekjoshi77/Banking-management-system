package com.bank.service;

import com.bank.dao.AccountDAO;
import com.bank.exception.AccountNotFoundException;
import com.bank.model.Account;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class AccountService {
    private final AccountDAO accountDAO;
    private final List<Account> accounts;

    public AccountService() {
        this.accounts = new ArrayList<>();
        this.accountDAO = null; // JDBC DAO will be connected in the next phase.
    }

    public void addAccount(Account account) {
        accounts.add(account);
    }

    public Account findAccount(String accountNumber) {
        return accounts.stream()
                .filter(account -> account.getAccountNumber().equals(accountNumber))
                .findFirst()
                .orElseThrow(() ->
                        new AccountNotFoundException("Account not found: " + accountNumber));
    }

    public void deposit(String accountNumber, BigDecimal amount) {
        findAccount(accountNumber).deposit(amount);
    }

    public void withdraw(String accountNumber, BigDecimal amount) {
        findAccount(accountNumber).withdraw(amount);
    }

    public BigDecimal getBalance(String accountNumber) {
        return findAccount(accountNumber).getBalance();
    }

    public List<Account> getAllAccounts() {
        return new ArrayList<>(accounts);
    }
}
