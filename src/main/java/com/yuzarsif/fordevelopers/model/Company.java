package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Company extends BaseUser {

    private String companyName;
    private String phoneNumber;
    @OneToOne(cascade = {CascadeType.REMOVE})
    @JoinColumn(name = "location_id")
    private Location location;
    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Advertisement> advertisements;
}
