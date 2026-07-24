package com.supportflow.helpdesk.service;

import com.supportflow.helpdesk.domain.entity.User;
import com.supportflow.helpdesk.dto.request.UserRequestDTO;
import com.supportflow.helpdesk.repository.UserRepository;
import com.supportflow.helpdesk.mapper.UserMapper;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with"));
    }

    public void delete(Long id) {
        User user = findById(id);
        userRepository.delete(user);
    }
    
}
