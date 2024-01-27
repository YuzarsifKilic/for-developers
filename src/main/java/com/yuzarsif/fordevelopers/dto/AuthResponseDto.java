package com.yuzarsif.fordevelopers.dto;

import com.yuzarsif.fordevelopers.model.Roles;
import lombok.Builder;

import java.util.Set;

@Builder
public record AuthResponseDto(
        String id,
        String token,
        Set<Roles> roles
) {
}
