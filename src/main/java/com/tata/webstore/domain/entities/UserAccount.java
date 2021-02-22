package com.tata.webstore.domain.entities;


import lombok.Data;

import java.util.Date;

@Data
public class UserAccount {
    private Long userId;
    private Address address;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private String emailId;
}
