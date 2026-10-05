package com.bank;

import com.bank.model.Customer;
import com.bank.model.SavingsAccount;
import com.bank.service.AccountService;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

class AccountServiceTest {

    @Test
    void depositShouldIncreaseBalance() {
        Customer customer = new Customer(1, "Test", "test@example.com", "9999999999", "Bengaluru");
        SavingsAccount account = new SavingsAccount("1001", customer, new BigDecimal("10000"));
        AccountService service = new AccountService();
        service.addAccount(account);

        service.deposit("1001", new BigDecimal("500"));

        assertEquals(new BigDecimal("10500"), service.getBalance("1001"));
    }

    @Test
    void withdrawalShouldDecreaseBalance() {
        Customer customer = new Customer(1, "Test", "test@example.com", "9999999999", "Bengaluru");
        SavingsAccount account = new SavingsAccount("1001", customer, new BigDecimal("10000"));
        AccountService service = new AccountService();
        service.addAccount(account);

        service.withdraw("1001", new BigDecimal("500"));

        assertEquals(new BigDecimal("9500"), service.getBalance("1001"));
    }
}
