package com.persnal.persnal_backend.borad.domain.user;

import lombok.Data;

@Data
public class UserResponseDTO {
    private String email;
    private String password;
    private String nickname;

    public UserResponseDTO(String email, String nickname) {
        this.email = email;
        this.nickname = nickname;
    }
}
