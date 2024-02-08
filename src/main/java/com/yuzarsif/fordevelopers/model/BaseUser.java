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
import java.util.Objects;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseUser baseUser = (BaseUser) o;
        return accountNonExpired == baseUser.accountNonExpired && isEnabled == baseUser.isEnabled && accountNonLocked == baseUser.accountNonLocked && credentialsNonExpired == baseUser.credentialsNonExpired && Objects.equals(id, baseUser.id) && Objects.equals(email, baseUser.email) && Objects.equals(password, baseUser.password) && Objects.equals(authorities, baseUser.authorities) && Objects.equals(createdAt, baseUser.createdAt) && Objects.equals(updatedAt, baseUser.updatedAt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, password, authorities, createdAt, updatedAt, accountNonExpired, isEnabled, accountNonLocked, credentialsNonExpired);
    }
}
