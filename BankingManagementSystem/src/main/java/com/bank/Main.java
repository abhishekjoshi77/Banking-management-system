package com.bank;

import com.bank.model.Customer;
import com.bank.model.SavingsAccount;
import com.bank.service.AccountService;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AccountService service = new AccountService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("========================================");
        System.out.println("       BANKING MANAGEMENT SYSTEM");
        System.out.println("========================================");

        Customer customer = new Customer(
                1,
                "Demo Customer",
                "demo@example.com",
                "9876543210",
                "Bengaluru"
        );

        SavingsAccount account = new SavingsAccount(
                "10000001",
                customer,
                new BigDecimal("10000.00")
        );

        service.addAccount(account);

        boolean running = true;

        while (running) {
            System.out.println("\n1. View Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. View Balance");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            String choice = scanner.nextLine();

            try {
                switch (choice) {
                    case "1" -> System.out.println(service.findAccount(account.getAccountNumber()));
                    case "2" -> {
                        System.out.print("Enter deposit amount: ");
                        BigDecimal amount = new BigDecimal(scanner.nextLine());
                        service.deposit(account.getAccountNumber(), amount);
                        System.out.println("Deposit successful.");
                    }
                    case "3" -> {
                        System.out.print("Enter withdrawal amount: ");
                        BigDecimal amount = new BigDecimal(scanner.nextLine());
                        service.withdraw(account.getAccountNumber(), amount);
                        System.out.println("Withdrawal successful.");
                    }
                    case "4" -> System.out.println("Balance: ₹" + service.getBalance(account.getAccountNumber()));
                    case "5" -> running = false;
                    default -> System.out.println("Invalid choice.");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        scanner.close();
        System.out.println("Thank you for using the Banking Management System.");
    }
}
