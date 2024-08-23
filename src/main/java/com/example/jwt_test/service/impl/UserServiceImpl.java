package com.example.jwt_test.service.impl;

import com.example.jwt_test.dto.UserDto;
import com.example.jwt_test.entity.UserEntity;
import com.example.jwt_test.repository.UserRepository;
import com.example.jwt_test.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    private PasswordEncoder passwordEncoder;


    @Override
    public String registerUser(UserDto userDto) {


        try {

            String encodedPassword = passwordEncoder.encode(userDto.getPassword());

            UserEntity userEntity = new UserEntity(
                    userDto.getName(),
                    userDto.getEmail(),
                    encodedPassword,
                    userDto.getRole()
            );

            userRepository.save(userEntity);
            return "Successfully Registered.";

        }catch (Exception e) {
            return "Registration Failed." + e.getMessage();

        }


    }
}
