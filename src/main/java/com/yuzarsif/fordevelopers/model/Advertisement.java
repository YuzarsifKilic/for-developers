package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class Advertisement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "company_id")
    private Company company;
    private String advertisementTitle;
    private String advertisementContent;
    @Enumerated(EnumType.STRING)
    private WorkType workType;
    @Enumerated(EnumType.STRING)
    private JobTitle jobTitle;
    @OneToMany(mappedBy = "advertisement", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Apply> applies;
}
