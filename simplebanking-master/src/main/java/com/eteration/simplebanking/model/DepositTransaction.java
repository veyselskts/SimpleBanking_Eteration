package com.eteration.simplebanking.model;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Represents a deposit transaction. Increases the account balance by the given amount.
 */

public class DepositTransaction extends Transaction {

    public DepositTransaction(double amount) {
        super(amount);
    }

    @Override
    public void apply(Account account) {
        account.credit(getAmount());
    }
}
