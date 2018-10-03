package controllers;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.data.Form;
import play.data.FormFactory;
import play.mvc.Controller;
import play.mvc.Result;
import play.mvc.Results;
import services.bookings.BookingService;
import util.dto.AddVehicleRq;

import javax.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

public class VehicleController extends Controller {

    @Inject
    private FormFactory formFactory;

    @Inject
    private BookingService bookingService;

    public CompletionStage<Result> addVehicle() {

        Form<AddVehicleRq> form = formFactory.form(AddVehicleRq.class)
                .bind(request().body().asJson());
        AddVehicleRq addVehicleRq = form.get();
        CompletableFuture<ObjectNode> response = bookingService.addVehicle(addVehicleRq);
        return response.thenApply(res ->
                Results.ok(res));
    }

}
