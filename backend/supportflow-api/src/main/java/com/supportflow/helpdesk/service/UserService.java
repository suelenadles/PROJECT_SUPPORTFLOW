package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.dto.request.UserRequestDTO;
import com.supportflow.helpdesk.repository.UserRepository;
import com.supportflow.helpdesk.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User create(UserRequestDTO dto) {
        User user = UserMapper.toEntity(dto);
        return userRepository.save(user);
    }
    
}
