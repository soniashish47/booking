package services.bookings;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Bookings;
import models.Vehicles;
import models.dao.IbookingsDAO;
import models.dao.IvehiclesDAO;
import util.Utility;
import util.constant.VehicleType;
import util.dto.AddVehicleRq;
import util.dto.ShowAvailablityRq;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class BookingService {

    @Inject
    private IvehiclesDAO vehicleDao;

    @Inject
    private IbookingsDAO bookingsDAO;

    public CompletableFuture<ObjectNode> addVehicle(AddVehicleRq addVehicleRq) {
        Vehicles vehicle = vehicleDao.addVehicle(addVehicleRq);
        return CompletableFuture.completedFuture(vehicle.toObjectNode());
    }

    CompletableFuture<ObjectNode> bookVehicle(ObjectNode node) {

        return null;
    }

    CompletableFuture<ObjectNode> showAvailable(ShowAvailablityRq showAvailablityRq) {
        VehicleType vehicleType = showAvailablityRq.getVehicleType();
        List<Bookings> bookingsList = bookingsDAO.findByVehicleType(vehicleType);
        Collections.sort(bookingsList, new Utility.SortBookingByTime());


        return null;
    }

    CompletableFuture<ObjectNode> cancelBooking(ObjectNode node) {

        return null;
    }

}
