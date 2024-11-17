package com.scalar.userservice.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class SigninRequestDto {

    private String email;
    private String password;
    private String name;
}
