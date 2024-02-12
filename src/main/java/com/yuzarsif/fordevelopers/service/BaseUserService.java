package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.exception.EmailInUseException;
import com.yuzarsif.fordevelopers.model.BaseUser;
import com.yuzarsif.fordevelopers.repository.BaseUserRepository;
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

    protected void emailInUse(String email) {
        baseUserRepository
                .findByEmail(email)
                .ifPresent(user -> {
                    throw new EmailInUseException("email already in use");});
    }
}
