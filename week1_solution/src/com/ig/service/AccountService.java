package com.ig.service;

import com.ig.exception.AccountNotFoundException;
import com.ig.exception.InsufficientFundsException;
import com.ig.exception.InvalidAmountException;
import com.ig.model.Account;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AccountService {
    private List<Account> accountList = new ArrayList<>();

    public boolean isValidAccount(int acNumber) throws AccountNotFoundException {
        for (Account account : accountList) {
            if (account.getAccNumber().equals(acNumber)) {
                return true;
            }
        }
        throw new AccountNotFoundException("Account number " + acNumber + " not found.");
    }

    public void deposit(int accNumber, float amt) throws InvalidAmountException, AccountNotFoundException {
        if (amt < 0) {
            throw new InvalidAmountException("Deposit amount cannot be negative.");
        }

        Account account = findAccount(accNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        account.setBalance(account.getBalance() + amt);
    }

    public void withdraw(int accNumber, float amt) throws InvalidAmountException, InsufficientFundsException, AccountNotFoundException {
        if (amt < 500) {
            throw new InvalidAmountException("Minimum withdrawal amount is 500.");
        }

        Account account = findAccount(accNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }

        float minBalance = account.getType() == Account.AccountType.SAVINGS ? 1000 : 5000;

        if (account.getBalance() - amt < minBalance) {
            throw new InsufficientFundsException("Insufficient funds for withdrawal.");
        }
        account.setBalance(account.getBalance() - amt);
    }

    public float getBalance(int accNumber) throws AccountNotFoundException {
        Account account = findAccount(accNumber);
        if (account == null) {
            throw new AccountNotFoundException("Account not found");
        }
        return account.getBalance();
    }

    private Account findAccount(int accNumber) {
        for (Account account : accountList) {
            if (account.getAccNumber().equals(accNumber)) {
                return account;
            }
        }
        return null;
    }

    public void addAccount(Account account) {
        accountList.add(account);
    }

    public List<Account> getAccountList() {
        return Collections.unmodifiableList(new ArrayList<>(accountList));
    }
}
