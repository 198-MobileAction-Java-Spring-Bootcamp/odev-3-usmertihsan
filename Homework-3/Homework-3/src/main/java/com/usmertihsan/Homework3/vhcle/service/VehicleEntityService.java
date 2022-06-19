package com.usmertihsan.Homework3.vhcle.service;

import com.usmertihsan.Homework3.gen.service.BaseEntityService;
import com.usmertihsan.Homework3.usr.entity.UsrUser;
import com.usmertihsan.Homework3.vhcle.dao.IVehicleDao;
import com.usmertihsan.Homework3.vhcle.entity.Vehicle;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleEntityService extends BaseEntityService<Vehicle, IVehicleDao> {
    public VehicleEntityService(IVehicleDao vehicleDao) {
        super(vehicleDao);
    }

    public Vehicle findByVehiclePlateNo(String plateNo)
    {
        return getDao().findByVehiclePlateNo(plateNo);
    }

    public List<Vehicle> findAllByVehicleBrand(String brandName)
    {
        return getDao().findAllByVehicleBrand(brandName);
    }

    public List<Vehicle> findAllByVehicleModel(String modelName)
    {
        return getDao().findAllByVehicleModel(modelName);
    }



}
