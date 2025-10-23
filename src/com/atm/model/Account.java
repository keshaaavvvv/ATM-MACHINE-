package com.atm.model;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private String accountNumber;
    private String username;
    private String pin;
    private double balance;
    private List<Transaction> transactions;

    public Account(String accountNumber, String username, String pin) {
        this.accountNumber = accountNumber;
        this.username = username;
        this.pin = pin;
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public boolean authenticate(String inputPin) {
        return this.pin.equals(inputPin);
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction("Deposit", amount));
    }

    public boolean withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Withdraw", amount));
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactionHistory() {
        return transactions;
    }

    public String getUsername() {
        return username;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}
