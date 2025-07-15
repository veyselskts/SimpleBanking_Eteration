package com.eteration.simplebanking.model;

public class PhoneBillPaymentTransaction extends WithdrawalTransaction {
    private String operator;
    private String phoneNumber;

    public PhoneBillPaymentTransaction(String operator, String phoneNumber, double amount) {
        super(amount);
        this.operator = operator;
        this.phoneNumber = phoneNumber;
    }

    public String getOperator() {
        return operator;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
