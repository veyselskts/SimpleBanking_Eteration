package com.eteration.simplebanking.services;

import com.eteration.simplebanking.model.*;
import com.eteration.simplebanking.controller.TransactionStatus;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Service class responsible for handling core account operations such as finding accounts and processing credit/debit transactions.
 */

@Service
public class AccountService {

    // In-memory "database" of accounts. Replaceable with JPA repository in the future.
    private final Map<String, Account> accountDatabase = new HashMap<>();
    
    // Add an account by account number for basic API test
    public void addAccount(Account account) {
        accountDatabase.put(account.getAccountNumber(), account);
    }

    // Retrieve an account by account number
    public Account findAccount(String accountNumber) {
        Account account = accountDatabase.get(accountNumber);
        if (account == null) {
            throw new RuntimeException("Account not found with number: " + accountNumber);
        }
        return account;
    }

    // Credit an account with a transaction
    public TransactionStatus credit(String accountNumber, DepositTransaction transaction) {
        Account account = findAccount(accountNumber);
        try {
            account.post(transaction);
            return new TransactionStatus("OK", transaction.getApprovalCode());
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException("Payment could not be uploaded. Please try again.", e);
        }
    }

    // Debit an account with a transaction
    public TransactionStatus debit(String accountNumber, WithdrawalTransaction transaction) throws InsufficientBalanceException {
        Account account = findAccount(accountNumber);
        try {
            account.post(transaction);
            return new TransactionStatus("OK", transaction.getApprovalCode());
        } catch (InsufficientBalanceException e) {
            throw new RuntimeException("Yetersiz bakiye", e);
        }
        
    }


}
