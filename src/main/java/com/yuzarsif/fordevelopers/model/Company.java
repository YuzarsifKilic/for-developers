package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Company company = (Company) o;
        return Objects.equals(companyName, company.companyName) && Objects.equals(phoneNumber, company.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), companyName, phoneNumber);
    }
}
