package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer startYear;
    private Integer endYear;
    private float gnp;
    @Enumerated(EnumType.STRING)
    private Degree degree;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "university_id")
    private University university;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "course_id")
    private Course course;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Education education = (Education) o;
        return Float.compare(gnp, education.gnp) == 0 && Objects.equals(id, education.id) && Objects.equals(startYear, education.startYear) && Objects.equals(endYear, education.endYear) && degree == education.degree && Objects.equals(university, education.university) && Objects.equals(course, education.course) && Objects.equals(employee, education.employee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, startYear, endYear, gnp, degree, university, course, employee);
    }
}
