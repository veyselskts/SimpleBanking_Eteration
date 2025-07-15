package com.eteration.simplebanking.model;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Represents a withdrawal transaction. Decreases the account balance by the given amount.
 *              Throws InsufficientBalanceException if the balance is too low.
 */
public class WithdrawalTransaction extends Transaction {

    public WithdrawalTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(Account account) throws InsufficientBalanceException {
        account.debit(getAmount());
    }
}