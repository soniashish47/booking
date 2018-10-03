package models;

import com.avaje.ebean.Model;
import play.libs.Time;
import util.constant.VehicleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class BookedSlots extends Model implements Serializable {

    @Enumerated(EnumType.STRING)
    VehicleType vehicleType;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_id")
    private long id;
    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    private Bookings booking;
    private Time startTime;

    private Time endTime;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Vehicles getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicles vehicle) {
        this.vehicle = vehicle;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public Bookings getBooking() {
        return booking;
    }

    public void setBooking(Bookings booking) {
        this.booking = booking;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "BookedSlots{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", type=" + type +
                ", booking=" + booking +
                ", vehicleType=" + vehicleType +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

    public static final Find<Long, BookedSlots> find = new Find<Long, BookedSlots>() {
    };
}
