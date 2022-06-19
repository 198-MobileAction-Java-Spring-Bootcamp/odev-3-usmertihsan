package com.usmertihsan.Homework3.vhcle.converter;

import com.usmertihsan.Homework3.usr.entity.UsrUser;
import com.usmertihsan.Homework3.vhcle.dto.VehicleDto;
import com.usmertihsan.Homework3.vhcle.dto.VehicleSaveRequestDto;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-06-18T00:18:48+0300",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 11.0.15 (Oracle Corporation)"
)
@Component
public class VehicleMapperImpl extends VehicleMapper {

    @Override
    public VehicleDto convertToVehicleDto(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }

        VehicleDto vehicleDto = new VehicleDto();

        vehicleDto.setUserId( vehicleUserId( vehicle ) );
        vehicleDto.setVehicleBrand( vehicle.getVehicleBrand() );
        vehicleDto.setVehicleModel( vehicle.getVehicleModel() );
        vehicleDto.setVehicleProductionYear( vehicle.getVehicleProductionYear() );
        vehicleDto.setVehiclePlateNo( vehicle.getVehiclePlateNo() );

        return vehicleDto;
    }

    @Override
    public Vehicle convertToVehicle(VehicleSaveRequestDto vehicleSaveRequestDto) {
        if ( vehicleSaveRequestDto == null ) {
            return null;
        }

        Vehicle vehicle = new Vehicle();

        vehicle.setUser( vehicleSaveRequestDtoToUsrUser( vehicleSaveRequestDto ) );
        vehicle.setVehicleBrand( vehicleSaveRequestDto.getVehicleBrand() );
        vehicle.setVehicleModel( vehicleSaveRequestDto.getVehicleModel() );
        vehicle.setVehicleProductionYear( vehicleSaveRequestDto.getVehicleProductionYear() );
        vehicle.setVehiclePlateNo( vehicleSaveRequestDto.getVehiclePlateNo() );

        return vehicle;
    }

    private Long vehicleUserId(Vehicle vehicle) {
        if ( vehicle == null ) {
            return null;
        }
        UsrUser user = vehicle.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected UsrUser vehicleSaveRequestDtoToUsrUser(VehicleSaveRequestDto vehicleSaveRequestDto) {
        if ( vehicleSaveRequestDto == null ) {
            return null;
        }

        UsrUser usrUser = new UsrUser();

        usrUser.setId( vehicleSaveRequestDto.getUserId() );

        return usrUser;
    }
}
