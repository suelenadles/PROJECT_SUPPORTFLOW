package com.supportflow.helpdesk.controller;

import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.service.UserService;
import com.supportflow.helpdesk.dto.request.UserRequestDTO;
import com.supportflow.helpdesk.dto.response.UserResponseDTO;
import com.supportflow.helpdesk.mapper.UserMapper;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponseDTO createUser(@RequestBody UserRequestDTO dto) {
        User user = userService.create(dto);
        return UserMapper.toResponse(user);
    }
    
}
