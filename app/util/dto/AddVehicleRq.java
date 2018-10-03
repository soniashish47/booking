package util.dto;

import util.constant.VehicleType;

import javax.validation.constraints.NotNull;

public class AddVehicleRq {

    @NotNull
    private VehicleType vehicleType;

    private String RegistrationNumber;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getRegistrationNumber() {
        return RegistrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        RegistrationNumber = registrationNumber;
    }
}
