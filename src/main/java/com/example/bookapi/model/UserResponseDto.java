package com.example.bookapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter @Setter 
public class UserResponseDto {
    private Long id;
    private String username;
    private String email;
}
