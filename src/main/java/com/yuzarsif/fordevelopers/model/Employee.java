package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Entity
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class Employee extends BaseUser {

    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String githubUsername;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Project> projects;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<SocialMedia> socialMedia;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Education> educations;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Experience> experiences;
    @OneToMany(mappedBy = "employee", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Apply> applies;
}
