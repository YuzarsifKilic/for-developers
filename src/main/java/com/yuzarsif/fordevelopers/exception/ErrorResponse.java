package com.yuzarsif.fordevelopers.exception;

import lombok.Builder;

import java.time.LocalDateTime;

@Builder
public record ErrorResponse(String message,
                            LocalDateTime timestamp) {
}
