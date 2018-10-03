package models.impl;

import models.Vehicles;
import models.dao.IvehiclesDAO;
import util.constant.VehicleType;
import util.dto.AddVehicleRq;

import java.util.List;

public class VehicleDaoImpl implements IvehiclesDAO {
    @Override
    public Vehicles findById(Long id) {
        return Vehicles.find.where().eq("id", id).findUnique();
    }

    @Override
    public List<Vehicles> findByVehicleType(VehicleType vehicleType) {
        return Vehicles.find.where().eq("type", vehicleType).findList();
    }

    @Override
    public Vehicles addVehicle(AddVehicleRq vehicleRq) {
        Vehicles vehicles = new Vehicles();
        vehicles.setRegistrationNumber(vehicleRq.getRegistrationNumber());
        vehicles.setType(vehicleRq.getVehicleType());
        vehicles.setBasePrice(getBasePrice(vehicleRq.getVehicleType()));
        vehicles.save();
        return vehicles;
    }

    private long getBasePrice(VehicleType vehicleType) {
        long basePrice = 0;
        switch (vehicleType) {
            case HATCHBACK:
                basePrice = 1000l;
                break;
            case SEDAN:
                basePrice = 2000l;
                break;
            case SUV:
                basePrice = 3000l;
                break;
            default:
                basePrice = 0;
                break;
        }
        return  basePrice;
    }
}
