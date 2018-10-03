package models.dao;

import com.google.inject.ImplementedBy;
import models.Vehicles;
import models.impl.VehicleDaoImpl;
import util.constant.VehicleType;
import util.dto.AddVehicleRq;

import java.util.List;

@ImplementedBy(VehicleDaoImpl.class)
public interface IvehiclesDAO {
    Vehicles findById(Long id);
    List<Vehicles> findByVehicleType(VehicleType vehicleType);
    Vehicles addVehicle(AddVehicleRq vehicle);
}
