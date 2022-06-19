package com.usmertihsan.Homework3.usr.converter;

import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import javax.annotation.processing.Generated;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-18T00:18:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
public class UsrUserMapperImpl implements UsrUserMapper {

    @Override
    public UsrUser convertToUser(UsrUserSaveRequestDto usrUserSaveRequestDto) {
        if ( usrUserSaveRequestDto == null ) {
            return null;
        }

        UsrUser usrUser = new UsrUser();

        usrUser.setUserName( usrUserSaveRequestDto.getUserName() );
        usrUser.setUserLastName( usrUserSaveRequestDto.getUserLastName() );
        usrUser.setUserNickName( usrUserSaveRequestDto.getUserNickName() );
        usrUser.setUserPassword( usrUserSaveRequestDto.getUserPassword() );
        usrUser.setUserEmail( usrUserSaveRequestDto.getUserEmail() );
        usrUser.setUserTelephoneNumber( usrUserSaveRequestDto.getUserTelephoneNumber() );

        return usrUser;
    }

    @Override
    public UsrUserDto convertToAddressDto(UsrUser usrUser) {
        if ( usrUser == null ) {
            return null;
        }

        UsrUserDto usrUserDto = new UsrUserDto();

        usrUserDto.setUserName( usrUser.getUserName() );
        usrUserDto.setUserLastName( usrUser.getUserLastName() );
        usrUserDto.setUserNickName( usrUser.getUserNickName() );
        usrUserDto.setUserPassword( usrUser.getUserPassword() );
        usrUserDto.setUserEmail( usrUser.getUserEmail() );
        usrUserDto.setUserTelephoneNumber( usrUser.getUserTelephoneNumber() );

        return usrUserDto;
    }
}
