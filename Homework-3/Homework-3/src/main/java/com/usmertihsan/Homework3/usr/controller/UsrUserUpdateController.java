package com.usmertihsan.Homework3.usr.controller;

import com.usmertihsan.Homework3.usr.service.UserService;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/userOperations")
public class UsrUserUpdateController {


    private final UserService userService;

    @PatchMapping("/updateUserPassword")
    public String updateUser(@RequestParam String nickName, String userOldPassword, String newPassword, String newPasswordValidate){

        String message = userService.updateUserPassword(nickName,userOldPassword,newPassword,newPasswordValidate);

        return message;
    }


    @DeleteMapping("deleteUserAndVehicles")
    public ResponseEntity deleteUserAllVehicles(@RequestParam String nickName){
        userService.deleteUser(nickName);
        return ResponseEntity.ok().build();
    }

    @GetMapping("findAllUserVehicles")
    public ResponseEntity findAllUserVehicles(@RequestParam String nickName){

        return ResponseEntity.ok(userService.findAllUserVehicles(nickName));

    }






}
