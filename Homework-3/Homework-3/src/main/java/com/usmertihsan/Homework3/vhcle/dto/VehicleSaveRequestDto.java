package com.usmertihsan.Homework3.vhcle.dto;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class VehicleSaveRequestDto {

    private String vehicleBrand;
    private String vehicleModel;
    private String vehicleProductionYear;
    private String vehiclePlateNo;
    private Long userId;
}
