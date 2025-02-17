package com.ig.model;

import com.ig.exception.InvalidAmountException;
import com.ig.exception.LowBalanceException;

public class Account {
    public enum AccountType {
        SAVINGS, CURRENT
    }

    Integer accNumber;
    String custName;
    AccountType type;
    Float balance;

    public Account(Integer accNumber, String custName, AccountType type, Float balance) throws LowBalanceException, InvalidAmountException {
        this.accNumber = accNumber;
        this.custName = custName;
        this.type = type;
        
        if (balance < 0) {
          throw new InvalidAmountException("Initial balance cannot be negative.");
        }

        if (type == AccountType.SAVINGS && balance < 1000) {
            throw new LowBalanceException("Initial balance for savings account must be at least 1000.");
        } else if (type == AccountType.CURRENT && balance < 5000) {
            throw new LowBalanceException("Initial balance for current account must be at least 5000.");
        }
        this.balance = balance;
    }


    public Integer getAccNumber() {
        return accNumber;
    }

    public String getCustName() {
        return custName;
    }

    public AccountType getType() {
        return type;
    }

    public Float getBalance() {
        return balance;
    }

    public void setBalance(Float balance) {
        this.balance = balance;
    }
}


