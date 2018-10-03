package models;

import com.avaje.ebean.Model;
import play.libs.Time;
import util.constant.VehicleType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table
public class Bookings extends Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "booking_id")
    private long id;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicles vehicle;

    @Enumerated(EnumType.STRING)
    private VehicleType type;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    private Time startTime;

    private Time endTime;

    private boolean canceled;

    public Bookings(Bookings bookings) {
        this.vehicle = bookings.getVehicle();
        this.type = bookings.getType();
        this.user = bookings.getUser();
        this.startTime = startTime;
        this.endTime = endTime;
        this.canceled = canceled;
    }

    public Bookings(Vehicles vehicle, VehicleType type, Users user, Time startTime, Time endTime, boolean canceled) {
        this.vehicle = vehicle;
        this.type = type;
        this.user = user;
        this.startTime = startTime;
        this.endTime = endTime;
        this.canceled = canceled;
    }

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

    public Users getUser() {
        return user;
    }

    public void setUser(Users user) {
        this.user = user;
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

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    @Override
    public String toString() {
        return "Bookings{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", type=" + type +
                ", user=" + user +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                ", canceled=" + canceled +
                '}';
    }

    public static final Find<Long, Bookings> find = new Find<Long, Bookings>() {
    };
}
