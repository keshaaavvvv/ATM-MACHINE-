package com.atm.service;

import com.atm.model.Account;

import java.util.HashMap;
import java.util.Map;

public class AtmService {
    private Map<String, Account> accounts = new HashMap<>();
    private Account currentAccount;

    public boolean signUp(String accountNumber, String username, String pin) {
        if (accounts.containsKey(accountNumber)) return false;
        accounts.put(accountNumber, new Account(accountNumber, username, pin));
        return true;
    }

    public boolean signIn(String accountNumber, String pin) {
        Account acc = accounts.get(accountNumber);
        if (acc != null && acc.authenticate(pin)) {
            currentAccount = acc;
            return true;
        }
        return false;
    }

    public Account getCurrentAccount() {
        return currentAccount;
    }
}
