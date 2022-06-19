package com.usmertihsan.Homework3.usr.controller;

import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import com.usmertihsan.Homework3.usr.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UsrUserController {

    private final UserService userService;

    @PostMapping("/newUser")
    public ResponseEntity saveNewUser(@RequestBody UsrUserSaveRequestDto usrUserSaveRequestDto) {
        userService.saveUser(usrUserSaveRequestDto);
        return ResponseEntity.ok(usrUserSaveRequestDto);
    }




}
