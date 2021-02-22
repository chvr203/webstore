package com.tata.webstore.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Address {
    private Long addressId;
    private String address;
    private String city;
    private String state;
    private String country;
    private long zip;
    private long phoneNumber;
    private String type;
}
