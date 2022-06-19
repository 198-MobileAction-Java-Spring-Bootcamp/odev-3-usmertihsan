package com.usmertihsan.Homework3.vhcle.controller;

import com.usmertihsan.Homework3.vhcle.dto.VehicleSaveRequestDto;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import com.usmertihsan.Homework3.vhcle.service.VehicleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/vehicles")
@RequiredArgsConstructor
public class VehicleController {

    private final VehicleService vehicleService;

    @PostMapping("/saveNewVehicle")
    public ResponseEntity saveNewVehicle(@RequestBody VehicleSaveRequestDto vehicleSaveRequestDto){
        vehicleService.saveVehicle(vehicleSaveRequestDto);
        return new ResponseEntity(vehicleSaveRequestDto, HttpStatus.CREATED);
    }

    @PatchMapping("/updateVehicle")
    public ResponseEntity updateVehicle(@RequestParam Long vehicleId,String vehicleBrand,String vehicleModel,String vehicleProductionYear,String vehiclePlateNo){

        Vehicle vehicle = vehicleService.updateVehicle(vehicleId,vehicleBrand,vehicleModel,vehicleProductionYear,vehiclePlateNo);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("deleteVehicle")
    public ResponseEntity deleteVehicle(@RequestParam Long id){
        vehicleService.deleteVehicle(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("findByModelName/")
    public ResponseEntity findByModelName(@RequestParam String modelName){

        List<Vehicle> vehicleList = vehicleService.findByModels(modelName);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }

    @GetMapping("findByBrandName/")
    public ResponseEntity findByModelBrandName(@RequestParam String brandName){

        List<Vehicle> vehicleList = vehicleService.findByBrands(brandName);
        return new ResponseEntity<>(vehicleList, HttpStatus.OK);
    }



}
