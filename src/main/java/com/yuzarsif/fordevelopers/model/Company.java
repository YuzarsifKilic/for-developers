package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Company extends BaseUser {

    private String companyName;
    private String phoneNumber;
    private String city;
}
