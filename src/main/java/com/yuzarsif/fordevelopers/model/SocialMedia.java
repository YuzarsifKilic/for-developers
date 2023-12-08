package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private SocialMedias socialMedia;
    private String url;
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
