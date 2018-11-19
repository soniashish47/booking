package services;

import models.dao.IvehiclesDAO;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import play.Application;
import play.db.Database;
import play.test.Helpers;
import play.test.WithApplication;
import util.TestUtil;

import static play.test.Helpers.inMemoryDatabase;


public class TestBookingService extends WithApplication {

    private IvehiclesDAO ivehiclesDAO;

    public static Application ApplicationWithDB ; //= Helpers.fakeApplication(Helpers.inMemoryDatabase());

    @BeforeClass
    public static void startApp() {
        Database database = TestUtil.getDatabase();
        ApplicationWithDB = Helpers.fakeApplication(inMemoryDatabase("test"));
        Helpers.start(ApplicationWithDB);
    }

    @AfterClass
    public static void stopApp() {
        Helpers.stop(ApplicationWithDB);
    }

    @Test
    public void addVehicle() {
        Helpers.running(ApplicationWithDB, () -> {

        });
    }

}
