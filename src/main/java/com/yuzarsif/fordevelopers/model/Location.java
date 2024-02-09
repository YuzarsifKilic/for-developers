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
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;
    private String districtName;
    @OneToOne(mappedBy = "location")
    private Company company;

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", city=" + city +
                ", districtName='" + districtName + '\'' +
                '}';
    }
}
