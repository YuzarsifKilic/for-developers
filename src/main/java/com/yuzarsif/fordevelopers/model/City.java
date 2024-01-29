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
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String cityName;
    @OneToMany(mappedBy = "city", fetch = FetchType.LAZY, cascade = {CascadeType.REMOVE})
    private Set<Location> locations;
}
