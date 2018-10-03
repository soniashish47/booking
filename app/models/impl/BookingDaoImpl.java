package models.impl;

import models.Bookings;
import models.dao.IbookingsDAO;
import util.constant.VehicleType;

import java.util.List;

public class BookingDaoImpl implements IbookingsDAO {

    @Override
    public Bookings findById(Long id) {
        return Bookings.find.where().eq("booking_id",id).findUnique();
    }

    @Override
    public List<Bookings> findByVehicleType(VehicleType vehicleType) {
        return Bookings.find.where().eq("type",vehicleType).findList();
    }

    @Override
    public List<Bookings> findByUser(long userId) {
        return Bookings.find.where().eq("user_id",userId).findList();
    }

    @Override
    public void saveBooking(Bookings bookings) {
        Bookings newBookings = new Bookings(bookings);
        newBookings.save();
    }

    @Override
    public void deleteBooking(Long id) {
        Bookings bookings = findById(id);
        bookings.setCanceled(true);
        bookings.save();
    }
}
