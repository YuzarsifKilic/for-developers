package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.model.BaseUser;
import com.yuzarsif.fordevelopers.repository.BaseUserRepository;
import org.apache.catalina.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BaseUserService {

    private final BaseUserRepository baseUserRepository;

    public BaseUserService(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    Optional<BaseUser> findByEmail(String email) {
        return baseUserRepository.findByEmail(email);
    }
}