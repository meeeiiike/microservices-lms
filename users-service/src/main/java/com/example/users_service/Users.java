package com.example.users_service;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Users {

    @NotNull
    private int id;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

}
