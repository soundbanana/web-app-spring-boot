package com.chemaev.dto;

import com.chemaev.model.UniqueEmail;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
public class CreateUserRequestDto {
    @NotBlank(message = "Name shouldn't be blank")
    @Size(min = 1, max = 100)
    private String name;

    @NotBlank(message = "Email shouldn't be blank")
    @Email
    @UniqueEmail
    private String email;

    @Past(message = "Birthdate should be real")
    @DateTimeFormat(pattern = "YYY-MM-DD")
    private LocalDate birthday;

    @Size(min = 8, max = 64, message = "Password should contain from 8 to 64 symbols")
    private String password;
}