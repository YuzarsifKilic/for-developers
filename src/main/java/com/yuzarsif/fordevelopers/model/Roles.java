package com.yuzarsif.fordevelopers.model;

import org.springframework.security.core.GrantedAuthority;

public enum Roles implements GrantedAuthority {

    ROLE_EMPLOYEE,
    ROLE_COMPANY;

    @Override
    public String getAuthority() {
        return name();
    }
}
