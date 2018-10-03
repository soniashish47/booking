package services.bookings;

import com.fasterxml.jackson.databind.node.ObjectNode;
import models.Vehicles;
import models.dao.IvehiclesDAO;
import util.dto.AddVehicleRq;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;

public class BookingService {

    @Inject
    private IvehiclesDAO vehicleDao;

    public CompletableFuture<ObjectNode> addVehicle(AddVehicleRq addVehicleRq) {
        Vehicles vehicle = vehicleDao.addVehicle(addVehicleRq);
        return CompletableFuture.completedFuture(vehicle.toObjectNode());
    }

    CompletableFuture<ObjectNode> bookVehicle(ObjectNode node) {

        return null;
    }

    CompletableFuture<ObjectNode> showAvailable(ObjectNode node) {

        return null;
    }

    CompletableFuture<ObjectNode> cancelBooking(ObjectNode node) {

        return null;
    }

}
