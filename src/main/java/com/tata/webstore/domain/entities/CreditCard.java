package com.tata.webstore.domain.entities;

import lombok.Data;

import java.util.Date;

@Data
public class CreditCard {
    private long creditCardNumber;
    private String cardType;
    private Date expiryDate;
}
