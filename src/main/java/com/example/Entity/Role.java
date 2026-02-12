package com.example.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "ROLES")
public class Role {
    @Id
    @Column(name = "USER-ROLEID")
    private UUID id=UUID.randomUUID();
    @Column(unique = true,nullable = false)
    private String RoleName;

}
