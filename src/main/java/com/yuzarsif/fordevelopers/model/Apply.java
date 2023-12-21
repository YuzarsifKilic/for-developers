package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Apply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "advertisement_id")
    private Advertisement advertisement;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
    @CreationTimestamp
    private LocalDate appliedDate;
}
