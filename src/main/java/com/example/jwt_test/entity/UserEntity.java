package com.example.jwt_test.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, length = 255)
    private String name;
    @Column(unique = true,nullable = false, length = 255)
    private String email;
    @Column(nullable = false , length = 255)
    private String password;
    @Column(nullable = false , length = 255)
    private String role;


    public UserEntity(String name, String email, String encode, String role) {
        this.name = name;
        this.email = email;
        this.password = encode;
        this.role = role;
    }
}
