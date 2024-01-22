package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class Company extends BaseUser {

    private String companyName;
    private String phoneNumber;
    private String city;
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Advertisement> advertisements;
}
