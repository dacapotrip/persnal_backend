package com.persnal.persnal_backend.borad.domain.user;

import lombok.Data;

@Data
public class UserRequestDTO {
    private String email;
    private String password;
    private String nickname;
}
