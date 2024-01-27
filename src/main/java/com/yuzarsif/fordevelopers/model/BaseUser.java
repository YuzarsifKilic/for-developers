package com.yuzarsif.fordevelopers.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Set;

@Entity(name = "user")
@Inheritance(strategy = InheritanceType.JOINED)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@Data
public class BaseUser implements UserDetails {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;
    private String email;
    private String password;
    @ElementCollection(targetClass = Roles.class, fetch = FetchType.EAGER)
    @JoinTable(name = "authorities", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "role", nullable = false)
    @Enumerated(EnumType.STRING)
    private Set<Roles> authorities;
    @CreationTimestamp
    private LocalDateTime createdAt;
    @UpdateTimestamp
    private LocalDateTime updatedAt;

    private boolean accountNonExpired;
    private boolean isEnabled;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;

    @Override
    public String getUsername() {
        return getEmail();
    }
}
