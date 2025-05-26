package com.example.bookapi.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter 
public class UserCreateDto {
    private String username;
    private String email;
    private String password; // ✅ Allow user to send raw password

    // Optionally add validation:
    // @NotBlank @Email, etc.
}

