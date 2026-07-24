package com.supportflow.helpdesk.dto.response;

import com.supportflow.helpdesk.domain.enums.UserRole;

public record UserResponseDTO (Long id,
    String name,
    String email,
    UserRole role) {
    
}
