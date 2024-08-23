package com.example.jwt_test.service;

import com.example.jwt_test.dto.UserDto;

public interface UserService {

    String registerUser(UserDto registerRequest);
}
