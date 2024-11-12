package com.persnal.persnal_backend.borad.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.persnal.persnal_backend.borad.dao.UserMapper;
import com.persnal.persnal_backend.borad.domain.user.UserRequestDTO;
import com.persnal.persnal_backend.borad.domain.user.UserResponseDTO;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public void registerUser(UserRequestDTO userRequestDTO) {
        if (userMapper.findByEmail(userRequestDTO.getEmail()) != null) {
            throw new IllegalArgumentException("Email already in use.");
        }
        userMapper.saveUser(userRequestDTO);
    }

    public UserResponseDTO authenticateUser(String email, String password) {
        UserRequestDTO user = userMapper.findByEmail(email);
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid email or password.");
        }
        return new UserResponseDTO(user.getEmail(), user.getNickname());
    }

}
