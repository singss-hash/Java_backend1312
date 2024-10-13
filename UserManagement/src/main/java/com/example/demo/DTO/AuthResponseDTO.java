package com.example.demo.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthResponseDTO {
    private String token;

    public AuthResponseDTO(String token, String loginSuccessful) {
        this.token = token;
    }

}


