package com.usmertihsan.Homework3.vhcle.converter;

import com.usmertihsan.Homework3.vhcle.dto.VehicleDto;
import com.usmertihsan.Homework3.vhcle.dto.VehicleSaveRequestDto;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import com.usmertihsan.Homework3.vhcle.service.VehicleEntityService;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public abstract class VehicleMapper {

    @Autowired
    VehicleEntityService vehicleEntityService;
    @Mapping(target = "userId",source = "user.id")
    public abstract VehicleDto convertToVehicleDto(Vehicle vehicle);

    @Mapping(target = "user.id",source = "userId")
    public abstract Vehicle convertToVehicle(VehicleSaveRequestDto vehicleSaveRequestDto);
}