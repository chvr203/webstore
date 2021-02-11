package com.tata.storeapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
    private long transactionId;
    private long amount;
    private TransactionType transactionType;
    private LocalDate dot;

}
