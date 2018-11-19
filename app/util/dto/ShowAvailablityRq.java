package util.dto;

import util.constant.VehicleType;

import javax.validation.constraints.NotNull;
import java.sql.Time;
import java.sql.Timestamp;

public class ShowAvailablityRq {

    @NotNull
    private VehicleType vehicleType;

    private Timestamp requestStartTime;

    private Timestamp requestEndTime;

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Timestamp getRequestStartTime() {
        return requestStartTime;
    }

    public void setRequestStartTime(Timestamp requestStartTime) {
        this.requestStartTime = requestStartTime;
    }

    public Timestamp getRequestEndTime() {
        return requestEndTime;
    }

    public void setRequestEndTime(Timestamp requestEndTime) {
        this.requestEndTime = requestEndTime;
    }
}
