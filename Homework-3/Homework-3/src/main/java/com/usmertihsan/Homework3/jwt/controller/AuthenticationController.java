package com.usmertihsan.Homework3.jwt.controller;


import com.usmertihsan.Homework3.jwt.dto.JwtLoginRequestDto;
import com.usmertihsan.Homework3.jwt.service.AuthenticationService;
import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto){

        UsrUserDto usrUserDto = authenticationService.register(usrUserSaveRequestDto);
        return ResponseEntity.ok(usrUserSaveRequestDto);
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody JwtLoginRequestDto jwtLoginRequestDto){

        String login = authenticationService.login(jwtLoginRequestDto);

        return ResponseEntity.ok(login);
    }

}
