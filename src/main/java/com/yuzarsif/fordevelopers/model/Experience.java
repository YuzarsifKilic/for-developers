package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Experience {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String companyName;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
    private LocalDate startYear;
    private LocalDate endYear;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
