package com.example.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "USER-TABLE")
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "USER_ID")
    private UUID id;
    @Column(name = "USER_NAME")
    private String name;
    @Email
    @NotBlank(message = "Email should not be null or empty")
    private  String email;
    @Column(name = "USER_PASS")
    private String password;
    private String Image;
    private boolean enable=true;
    private Instant createdAt=Instant.now();
    private Instant updatedAt=Instant.now();
    @Enumerated(EnumType.STRING)
    private Provider provider=Provider.LOCAL;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "USER_ROLE",
            joinColumns = @JoinColumn(name = "USER_ID"),
            inverseJoinColumns = @JoinColumn(name = "ROLE_ID")
    )
    private Set<Role> roles= new HashSet<>();
    @PrePersist
    protected void onCreate(){
        Instant now = Instant.now();
        if(createdAt==null){
            createdAt=now;
        }
        updatedAt=now;
    }
    @PostPersist
    protected void  onUpdate(){
        updatedAt=Instant.now();
    }
}
