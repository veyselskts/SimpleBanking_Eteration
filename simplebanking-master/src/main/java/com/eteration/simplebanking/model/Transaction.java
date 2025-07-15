package com.eteration.simplebanking.model;

import java.util.Date;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Abstract base class for all transaction types. Contains shared fields like amount, date, and approvalCode.
 */

public abstract class Transaction {
    
    private double amount;
    private Date date;
    private String approvalCode;

    public Transaction(double amount) {
        this.amount = amount;
    }

    public abstract void apply(Account account) throws InsufficientBalanceException;

    public double getAmount() {
        return amount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getApprovalCode() {
        return approvalCode;
    }

    public void setApprovalCode(String approvalCode) {
        this.approvalCode = approvalCode;
    }

    public String getType() {
        return this.getClass().getSimpleName();
    }
}
