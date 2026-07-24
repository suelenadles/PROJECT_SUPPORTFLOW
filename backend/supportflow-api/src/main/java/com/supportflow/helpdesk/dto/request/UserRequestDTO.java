package com.supportflow.helpdesk.dto.request;

import com.supportflow.helpdesk.domain.enums.UserRole;

public record UserRequestDTO(
    String name,
    String email,
    String password,
    UserRole role
) {
    
}
