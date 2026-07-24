package com.supportflow.helpdesk.mapper;

import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.dto.request.UserRequestDTO;
import com.supportflow.helpdesk.dto.response.UserResponseDTO;

public class UserMapper {

    private UserMapper() {
    }

    public static User toEntity(UserRequestDTO dto) {

        User user = new User();

        user.setName(dto.name());
        user.setEmail(dto.email());
        user.setPassword(dto.password());
        user.setRole(dto.role());

        return user;
    }

    public static UserResponseDTO toResponse(User user) {
        return new UserResponseDTO(
                user.getId(),
                user.getName(),
                user.getEmail(),
                user.getRole()
        );
    }
    
}
