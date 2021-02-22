package com.tata.webstore.domain.entities;

import lombok.Data;

import java.sql.Date;

@Data
public class CreditCard {
    private long cardId;
    private long creditCardNumber;
    private String cardType;
    private Date expiryDate;
}
