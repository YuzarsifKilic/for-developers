package com.yuzarsif.fordevelopers.service;

import com.yuzarsif.fordevelopers.model.BaseUser;
import com.yuzarsif.fordevelopers.repository.BaseUserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final BaseUserRepository baseUserRepository;

    public UserDetailsServiceImpl(BaseUserRepository baseUserRepository) {
        this.baseUserRepository = baseUserRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<BaseUser> user = baseUserRepository.findByEmail(username);
        return user.orElseThrow(EntityNotFoundException::new);
    }
}
