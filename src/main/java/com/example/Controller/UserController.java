package com.example.Controller;

import com.example.DTO.UserDTO;
import com.example.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class UserController {
    private final UserService userService;
    @PostMapping
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO){
        return new ResponseEntity<>(userService.createUser(userDTO), HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<Iterable<UserDTO>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(),HttpStatus.OK);
    }
    @GetMapping("/email/{email}")
    public ResponseEntity<UserDTO> getUserByEmail(@PathVariable String email){
        return new ResponseEntity<>(userService.getUserByEmail(email),HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<UserDTO> getUserByUUID(@PathVariable UUID id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);
    }
    @PutMapping("/{userId}")  //api/v1/users/{userId}
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto, @PathVariable("userId") String userId) {
        return ResponseEntity.ok(userService.updateUser(userDto, userId));
    }

}
