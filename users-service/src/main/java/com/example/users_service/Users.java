package com.example.users_service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Users {

    @NotNull
    @Positive
    private Long id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
