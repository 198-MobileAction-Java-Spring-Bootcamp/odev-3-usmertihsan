package com.usmertihsan.Homework3.vhcle.service;



import com.usmertihsan.Homework3.vhcle.converter.VehicleMapper;
import com.usmertihsan.Homework3.vhcle.dto.VehicleDto;
import com.usmertihsan.Homework3.vhcle.dto.VehicleSaveRequestDto;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VehicleService {

    private final VehicleEntityService vehicleEntityService;
    final private VehicleMapper vehicleMapper;

    public VehicleDto saveVehicle(VehicleSaveRequestDto vehicleSaveRequestDto) {
        Vehicle vehicle = vehicleMapper.convertToVehicle(vehicleSaveRequestDto);

        // check if plate no already exist
        if(vehicleEntityService.findByVehiclePlateNo(vehicle.getVehiclePlateNo())!=null)
        {
            throw new RuntimeException("The vehicle already exist by another users. You can not add!");
        }
        String checkPlateNo = vehicle.getVehiclePlateNo();

        // check plate no if it contains space
        if(checkPlateNo!= null){
            for(int i = 0; i < checkPlateNo.length(); i++){
                if(Character.isWhitespace(checkPlateNo.charAt(i))){
                    throw new RuntimeException("The plate no can not contains spaces.");
                }
            }
        }
        // check plate no contains only english chars
        while(!checkPlateNo.matches("[a-zA-Z0-9]*")) {
            throw new RuntimeException("The plate no only can contain english chars.");
        }

        // convert to lower cases to upper cases
        vehicle.setVehiclePlateNo(checkPlateNo.toUpperCase());

        vehicle = vehicleEntityService.save(vehicle);
        VehicleDto vehicleDto = vehicleMapper.convertToVehicleDto(vehicle);
        return vehicleDto;
    }

    public void findDeleteVehicles(Long id)
    {
        List<Vehicle> vehicleList = vehicleEntityService.findAll();
        for (Vehicle vehicle : vehicleList) {
            if (Objects.equals(vehicle.getUser().getId(), id)) {
                vehicleEntityService.delete(vehicle);
            }
        }
    }


    public List<Vehicle> findUserVehicles(Long id)
    {
        List<Vehicle> vehicleList = vehicleEntityService.findAll();
        List<Vehicle> customizedUserVehicleList = new ArrayList<>();
        for (Vehicle vehicle : vehicleList) {
            if (Objects.equals(vehicle.getUser().getId(), id)) {
                customizedUserVehicleList.add(vehicle);
            }
        }
        return  customizedUserVehicleList;
    }

    public Vehicle updateVehicle(Long vehicleId,String vehicleBrand,String vehicleModel,String vehicleProductionYear,String vehiclePlateNo)
    {
        Vehicle vehicle = vehicleEntityService.findById(vehicleId);
        vehicle.setVehicleBrand(vehicleBrand);
        vehicle.setVehicleModel(vehicleModel);
        vehicle.setVehicleProductionYear(vehicleProductionYear);
        vehicle.setVehiclePlateNo(vehiclePlateNo);
        vehicle = vehicleEntityService.save(vehicle);
        return vehicle;
    }

    public void deleteVehicle(Long id)
    {
        Vehicle vehicle = vehicleEntityService.findById(id);
        vehicleEntityService.delete(vehicle);
    }

    public List<Vehicle> findByModels(String model)
    {
        List<Vehicle> vehicleList = vehicleEntityService.findAllByVehicleModel(model);
        return  vehicleList;
    }

    public List<Vehicle> findByBrands(String brand)
    {
        List<Vehicle> vehicleList = vehicleEntityService.findAllByVehicleBrand(brand);
        return  vehicleList;
    }




}
