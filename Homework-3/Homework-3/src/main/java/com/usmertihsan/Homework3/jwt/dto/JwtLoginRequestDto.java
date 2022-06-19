package com.usmertihsan.Homework3.jwt.dto;

import lombok.Data;

@Data
public class JwtLoginRequestDto {

    private String userNickName;
    private String userPassword;
}
