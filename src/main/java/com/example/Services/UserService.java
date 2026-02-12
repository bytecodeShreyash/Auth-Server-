package com.example.Services;

import com.example.DTO.UserDTO;
import com.example.Entity.User;

import java.util.List;

public interface UserService {
    UserDTO createUser(UserDTO userDTO);
    UserDTO getUserByEmail(String email);
    UserDTO updateUser(UserDTO userDTO,String userID);
    void deleteUserById(String userID);
    Iterable<UserDTO> getAllUsers();
}
