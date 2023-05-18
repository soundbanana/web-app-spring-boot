package com.chemaev.service;


import com.chemaev.dto.CreateUserRequestDto;
import com.chemaev.dto.UserResponseDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    UserResponseDto createUser(CreateUserRequestDto userDto, String url);

    boolean verify(String verificationCode);

    void sendVerificationMail(String mail, String name, String code, String url);

    List<UserResponseDto> findAll();

    Optional<UserResponseDto> findAllByEmail(String email);

    Optional<UserResponseDto> findByEmail(String email);

    //TODO Add other methods
}