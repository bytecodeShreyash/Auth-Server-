package com.example.Services.Impl;

import com.example.DTO.UserDTO;
import com.example.Entity.Provider;
import com.example.Entity.User;
import com.example.Exception.ResourceNotFoundException;
import com.example.Repositories.UserRepository;
import com.example.Services.UserService;
import com.example.Utils.UserHelper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public UserDTO createUser(UserDTO userDTO) {
        if (userRepository.existsByEmail(userDTO.getEmail())) {
            throw new IllegalArgumentException("User with this email already exists");
        }
        User user = modelMapper.map(userDTO, User.class);
        user.setEnable(true);
        user.setProvider(Provider.LOCAL);
        User savedUser = userRepository.save(user);
        return  modelMapper.map(savedUser, UserDTO.class);
    }


    @Override
    @Transactional
    public UserDTO getUserByEmail(String email) {
        User user= userRepository.findByEmail(email)
                .orElseThrow(()-> new ResourceNotFoundException("user not found with given email ID !!"));
        return modelMapper.map(user,UserDTO.class);
    }

    @Override
    @Transactional
    public UserDTO updateUser(UserDTO userDto, String userId) {
        UUID uId = UserHelper.parseUUID(userId);
        User existingUser = userRepository
                .findById(uId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with given id"));
        if (userDto.getName() != null) existingUser.setName(userDto.getName());
        if (userDto.getImage() != null) existingUser.setImage(userDto.getImage());
        if (userDto.getProvider() != null) existingUser.setProvider(userDto.getProvider());
        existingUser.setEnable(userDto.isEnable());
        existingUser.setUpdatedAt(Instant.now());
        User updatedUser = userRepository.save(existingUser);
        return modelMapper.map(updatedUser, UserDTO.class);
    }

    @Override
    @Transactional
    public void deleteUserById(String userID) {
        UUID uuid= UserHelper.parseUUID(userID);
        User user=userRepository.findById(uuid)
                .orElseThrow(()-> new ResourceNotFoundException("user not found with given email ID !!"));

        userRepository.delete(user);
    }

    @Override
    @Transactional
    public Iterable<UserDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .toList();
    }

    @Override
    @Transactional
    public UserDTO getUserById(UUID id) {

        User user = userRepository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("User not found with given UUID"));

        return modelMapper.map(user, UserDTO.class);
    }


}
