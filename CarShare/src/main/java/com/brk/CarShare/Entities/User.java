package com.brk.CarShare.Entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Document(collection = "role")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String userID;
    private String roleID;
    private String driverLicenceNo;
    private String firstName;
    private String lastName;
    private String country;
    private String city;
    private String address;
    private String phoneNo;
    private String joinDate;
    private String subscriptionTier;
    private String billingCycle;
}
