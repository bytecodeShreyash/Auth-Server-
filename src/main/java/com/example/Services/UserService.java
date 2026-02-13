package com.example.Services;
import com.example.DTO.UserDTO;
import java.util.UUID;

public interface UserService {
    public UserDTO createUser(UserDTO userDTO);
    public UserDTO getUserByEmail(String email);
    public UserDTO updateUser(UserDTO userDTO,String userID);
    public void deleteUserById(String userID);
    public Iterable<UserDTO> getAllUsers();
    public UserDTO getUserById(UUID uuid);

}
