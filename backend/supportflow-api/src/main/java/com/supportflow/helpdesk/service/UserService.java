package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.dto.request.UserRequestDTO;
import com.supportflow.helpdesk.repository.UserRepository;
import com.supportflow.helpdesk.mapper.UserMapper;
import org.springframework.security.crypto.password.PasswordEncoder;
import com.supportflow.helpdesk.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User create(UserRequestDTO dto) {
        User user = UserMapper.toEntity(dto);
        user.setPassword(passwordEncoder.encode(dto.password()));
        return userRepository.save(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with ID: " + id));
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
    
}
