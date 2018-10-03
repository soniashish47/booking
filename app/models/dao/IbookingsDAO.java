package models.dao;

import com.google.inject.ImplementedBy;
import models.Bookings;
import models.impl.BookingDaoImpl;
import util.constant.VehicleType;

import java.util.List;

@ImplementedBy(BookingDaoImpl.class)
public interface IbookingsDAO {

    Bookings findById(Long id);
    List<Bookings> findByVehicleType(VehicleType vehicleType);
    List<Bookings> findByUser(long userId);
    void saveBooking(Bookings bookings);
    void deleteBooking(Long id);
}
