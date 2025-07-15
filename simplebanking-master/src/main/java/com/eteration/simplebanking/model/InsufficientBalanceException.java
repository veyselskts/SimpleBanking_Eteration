package com.eteration.simplebanking.model;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Custom exception class thrown when an account has insufficient balance for withdrawal.
 */
public class InsufficientBalanceException extends Exception {

    public InsufficientBalanceException(String message) {
        super(message);
    }
}
