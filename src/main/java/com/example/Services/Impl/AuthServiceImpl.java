package com.example.Services.Impl;

import com.example.DTO.UserDTO;
import com.example.Services.AuthService;
import com.example.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final UserService userService;
   // private  final PasswordEncoder passwordEncoder;
    @Override
    public UserDTO registerUser(UserDTO userDto) {
       // userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userService.createUser(userDto);
    }
}
