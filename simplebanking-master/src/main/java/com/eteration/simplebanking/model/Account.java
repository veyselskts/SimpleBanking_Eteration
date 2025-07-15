package com.eteration.simplebanking.model;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Represents a simple bank account with basic operations such as credit, debit,
 *              and transaction posting. Holds account metadata and a list of transactions.
 */

public class Account {

    private String owner;
    private String accountNumber;
    private double balance;
    private Date createDate;
    private List<Transaction> transactions;

    public Account(String owner, String accountNumber) {
        this.owner = owner;
        this.accountNumber = accountNumber;
        this.balance = 0.0;
        this.createDate = new Date();
        this.transactions = new ArrayList<>();
    }

    public void post(Transaction transaction) throws InsufficientBalanceException {
        transaction.apply(this);
        transaction.setApprovalCode(UUID.randomUUID().toString());
        transaction.setDate(new Date());
        transactions.add(transaction);
    }

    public String getOwner() {
        return owner;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void credit(double amount) {
        this.balance += amount;
    }

    public void debit(double amount) throws InsufficientBalanceException {
        if (balance < amount) {
            throw new InsufficientBalanceException("Yetersiz bakiye");
        }
        this.balance -= amount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public Date getCreateDate() {
        return createDate;
    }
}