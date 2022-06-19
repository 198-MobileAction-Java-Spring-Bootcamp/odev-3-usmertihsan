package com.usmertihsan.Homework3.usr.service;

import com.usmertihsan.Homework3.usr.converter.UsrUserMapper;
import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import com.usmertihsan.Homework3.vhcle.service.VehicleEntityService;
import com.usmertihsan.Homework3.vhcle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {


    private final UserEntityService userEntityService;

    private final VehicleService vehicleService;
    private final PasswordEncoder passwordEncoder;

    public UsrUserDto saveUser(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        UsrUser user = UsrUserMapper.INSTANCE.convertToUser(usrUserSaveRequestDto);

        if(userEntityService.findByUserNickName(user.getUserNickName())!=null)
        {
            throw new RuntimeException("User nick name already choosen! try another nick name");
        }

        String password = passwordEncoder.encode(user.getUserPassword());
        user.setUserPassword(password);
        user = userEntityService.save(user);
        UsrUserDto usrUserDto = UsrUserMapper.INSTANCE.convertToAddressDto(user);
        return usrUserDto;
    }

    public String updateUserPassword(String nickName,String userOldPassword, String newPassword, String newPasswordValidate) {

        UsrUser user = userEntityService.findByUserNickName(nickName);

        if(!passwordEncoder.matches(userOldPassword,user.getUserPassword()))
        {
            throw new RuntimeException("Old password is wrong!");
        }

        if(newPassword == newPasswordValidate)
        {

           String newValidatedPassword = passwordEncoder.encode(newPassword);
           user.setUserPassword(newValidatedPassword);
        }

        else
        {
            throw new RuntimeException("New password does not match!");
        }

        return "Password change is successful";
    }

    public String deleteUser(String nickName) {

        UsrUser user = userEntityService.findByUserNickName(nickName);
        if(userEntityService.findByUserNickName(user.getUserNickName())!=null)
        {
            Long userId = user.getId();

            vehicleService.findDeleteVehicles(userId);
            userEntityService.delete(user);
        }

        return "All deleted";
    }

    public List<Vehicle> findAllUserVehicles(String nickName) {

        UsrUser user = userEntityService.findByUserNickName(nickName);
        List<Vehicle> vehicleList = new ArrayList<>();

        if (userEntityService.findByUserNickName(user.getUserNickName()) != null) {
            Long userId = user.getId();
            vehicleList = vehicleService.findUserVehicles(userId);
        }
        return vehicleList;
    }
}
