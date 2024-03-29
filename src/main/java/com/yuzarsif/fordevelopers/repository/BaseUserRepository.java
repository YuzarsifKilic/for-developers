package com.yuzarsif.fordevelopers.repository;

import com.yuzarsif.fordevelopers.model.BaseUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BaseUserRepository extends JpaRepository<BaseUser, String> {

    Optional<BaseUser> findByEmail(String email);
}
