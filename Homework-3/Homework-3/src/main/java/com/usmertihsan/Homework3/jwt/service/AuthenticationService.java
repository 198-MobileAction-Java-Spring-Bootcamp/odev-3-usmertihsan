package com.usmertihsan.Homework3.jwt.service;

import com.usmertihsan.Homework3.jwt.dto.JwtLoginRequestDto;
import com.usmertihsan.Homework3.jwt.enums.JwtConstant;
import com.usmertihsan.Homework3.jwt.security.JwtTokenGenerator;
import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import com.usmertihsan.Homework3.usr.service.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthenticationService {


    private final AuthenticationManager authenticationManager;
    private final JwtTokenGenerator jwtTokenGenerator;
    private final UserService userService;

    public UsrUserDto register(UsrUserSaveRequestDto usrUserSaveRequestDto)
    {
        return userService.saveUser(usrUserSaveRequestDto);

    }

    public String login(JwtLoginRequestDto jwtLoginRequestDto) {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                jwtLoginRequestDto.getUserNickName(), jwtLoginRequestDto.getUserPassword()
        );

        Authentication authentication = authenticationManager.authenticate(authenticationToken);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        String token = jwtTokenGenerator.generateJwtToken(authentication);

        String fullToken = JwtConstant.BEARER.getConstant() + token;

        return fullToken;
    }


}
