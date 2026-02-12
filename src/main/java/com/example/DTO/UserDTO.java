package com.example.DTO;

import com.example.Entity.Provider;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDTO {
    private UUID id;
    private String name;
    private  String email;
    private String password;
    private String Image;
    private boolean enable=true;
    private Instant createdAt=Instant.now();
    private Instant updatedAt=Instant.now();
    private Provider provider=Provider.LOCAL;
    private Set<RoleDTO> roles= new HashSet<>();
}
