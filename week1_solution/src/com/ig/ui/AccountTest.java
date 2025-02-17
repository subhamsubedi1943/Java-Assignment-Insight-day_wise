package com.ig.ui;

import com.ig.exception.AccountNotFoundException;
import com.ig.exception.InsufficientFundsException;
import com.ig.exception.InvalidAmountException;
import com.ig.exception.LowBalanceException;
import com.ig.model.Account;
import com.ig.service.AccountService;
import java.util.List;
import java.util.Scanner;

public class AccountTest {
    private static AccountService accountService = new AccountService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        
        try {
            accountService.addAccount(new Account(123, "John Doe", Account.AccountType.SAVINGS, 5000f));
            accountService.addAccount(new Account(456, "Jane Doe", Account.AccountType.CURRENT, 10000f));
            accountService.addAccount(new Account(789, "Peter Pan", Account.AccountType.SAVINGS, 2000f));
            accountService.addAccount(new Account(101, "Alice Wonderland", Account.AccountType.CURRENT, 15000f));
            accountService.addAccount(new Account(202, "Bob Builder", Account.AccountType.SAVINGS, 3000f));
        } catch (LowBalanceException | InvalidAmountException e) {
            System.err.println("Error creating static accounts: " + e.getMessage());
            return; 
        }

        boolean running = true;
        while (running) {
            displayMenu();
            int choice = getIntegerInput("Enter your choice: ");

            switch (choice) {
                case 1:
                    deposit();
                    break;
                case 2:
                    withdraw();
                    break;
                case 3:
                    getBalance();
                    break;
                case 4:
                    listAccounts();
                    break;
                case 5:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
        scanner.close();
    }

    private static void displayMenu() {
        System.out.println("\nAccount Management Menu:");
        System.out.println("1. Deposit");
        System.out.println("2. Withdraw");
        System.out.println("3. Get Balance");
        System.out.println("4. List Accounts");
        System.out.println("5. Exit");
    }


    private static void deposit() {
        try {
            int accNumber = getIntegerInput("Enter account number: ");
            float amt = getFloatInput("Enter deposit amount: ");
            accountService.deposit(accNumber, amt);
            System.out.println("Deposit successful.");
        } catch (InvalidAmountException | AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void withdraw() {
        try {
            int accNumber = getIntegerInput("Enter account number: ");
            float amt = getFloatInput("Enter withdrawal amount: ");
            accountService.withdraw(accNumber, amt);
            System.out.println("Withdrawal successful.");
        } catch (InvalidAmountException | InsufficientFundsException | AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void getBalance() {
        try {
            int accNumber = getIntegerInput("Enter account number: ");
            float balance = accountService.getBalance(accNumber);
            System.out.println("Balance: " + balance);
        } catch (AccountNotFoundException e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    private static void listAccounts() {
        List<Account> accounts = accountService.getAccountList();

        if (accounts.isEmpty()) {
            System.out.println("No accounts have been created yet.");
            return;
        }

        System.out.println("\nList of Accounts:");
        for (Account account : accounts) {
            System.out.println("Account Number: " + account.getAccNumber());
            System.out.println("Customer Name: " + account.getCustName());
            System.out.println("Account Type: " + account.getType());
            System.out.println("Balance: " + account.getBalance());
            System.out.println("--------------------");
        }
    }

    private static int getIntegerInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter an integer.");
            scanner.next(); 
        }
        return scanner.nextInt();
    }

    private static float getFloatInput(String prompt) {
        System.out.print(prompt);
        while (!scanner.hasNextFloat()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextFloat();
    }

    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.next();
    }
}