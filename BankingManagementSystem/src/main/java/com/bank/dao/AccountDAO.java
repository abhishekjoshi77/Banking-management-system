package com.bank.dao;

import com.bank.model.Account;

import java.util.List;

public interface AccountDAO {
    void save(Account account);
    Account findByAccountNumber(String accountNumber);
    List<Account> findAll();
    void update(Account account);
    void delete(String accountNumber);
}
