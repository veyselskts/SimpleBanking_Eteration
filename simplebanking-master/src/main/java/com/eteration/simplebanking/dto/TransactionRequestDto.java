package com.eteration.simplebanking.dto;

import jakarta.validation.constraints.Min;

/*
 * Author: Mehmet Veysel Işıktaş
 * Created for: Eteration Simple Banking Assignment
 * Description: Data Transfer Object for handling transaction amount input in REST requests.
 */

public class TransactionRequestDto {

    @Min(value = 0, message = "Amount must be greater than 0")
    private double amount;

    public TransactionRequestDto() {
    }

    public TransactionRequestDto(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }
}
