package com.example.Services;

import com.example.DTO.UserDTO;
import com.example.Entity.User;
import com.example.Repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
       User user= modelMapper.map(userDTO, User.class);
        User savedUser=userRepository.save(user);
        return modelMapper.map(savedUser,UserDTO.class);
    }

    @Override
    public UserDTO getUserByEmail(String email) {
//        User user = userRepository
//                .findByEmail(email)
//                .orElseThrow(() -> new ResourceNotFoundException("User not found with given email id "));
//        return modelMapper.map(user,UserDTO.class);
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, String userID) {
        return null;
    }

    @Override
    public void deleteUserById(String userID) {

    }

    @Override
    public Iterable<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }



}
