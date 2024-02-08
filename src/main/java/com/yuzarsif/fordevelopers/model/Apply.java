package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Apply apply = (Apply) o;
        return Objects.equals(id, apply.id) && Objects.equals(advertisement, apply.advertisement) && Objects.equals(employee, apply.employee) && Objects.equals(appliedDate, apply.appliedDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, advertisement, employee, appliedDate);
    }

    @Override
    public String toString() {
        return "Apply{" +
                "id=" + id +
                ", advertisement=" + advertisement +
                ", employee=" + employee +
                ", appliedDate=" + appliedDate +
                '}';
    }
}
