package com.usmertihsan.Homework3.usr.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class UsrUserSaveRequestDto {

    private String userName;
    private String userLastName;
    private String userNickName;
    private String userPassword;
    private String userEmail;
    private String userTelephoneNumber;
}
