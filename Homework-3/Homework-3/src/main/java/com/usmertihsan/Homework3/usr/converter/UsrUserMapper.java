package com.usmertihsan.Homework3.usr.converter;


import com.usmertihsan.Homework3.usr.dto.UsrUserDto;
import com.usmertihsan.Homework3.usr.dto.UsrUserSaveRequestDto;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UsrUserMapper {

    UsrUserMapper INSTANCE = Mappers.getMapper(UsrUserMapper.class);

    UsrUser convertToUser(UsrUserSaveRequestDto usrUserSaveRequestDto);

    UsrUserDto convertToAddressDto(UsrUser usrUser);

}
