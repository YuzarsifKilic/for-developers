package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
@ToString(exclude = {"projects", "socialMedia", "educations", "experiences", "applies"})
public class Employee extends BaseUser {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String githubUsername;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<Project> projects;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<SocialMedia> socialMedia;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<Education> educations;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "employee", fetch = FetchType.EAGER, cascade = {CascadeType.REMOVE})
    private Set<Apply> applies;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName) && Objects.equals(phoneNumber, employee.phoneNumber) && Objects.equals(githubUsername, employee.githubUsername);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), firstName, lastName, phoneNumber, githubUsername);
    }
}
