package models;

import com.fasterxml.jackson.databind.node.ObjectNode;
import io.ebean.Finder;
import io.ebean.Model;
import play.libs.Json;
import util.constant.VehicleType;

import javax.persistence.*;
import java.io.Serializable;

/*Vehicle:
* Model which define real vehicle
* vehicle has it's properties defined in this class
* including base price
* */
@Entity
@Table(name = "vehicles")
public class Vehicles extends Model implements Serializable {

    public static final Finder<VehicleType, Vehicles> find = new Finder<VehicleType, Vehicles>(Vehicles.class) {
    };
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Enumerated(EnumType.STRING)
    private VehicleType type;
    private long basePrice;
    private String registrationNumber;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }

    public long getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(long basePrice) {
        this.basePrice = basePrice;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", type=" + type +
                ", basePrice=" + basePrice +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    public ObjectNode toObjectNode() {
        ObjectNode node = Json.newObject();
        node.put("id", id);
        node.put("type", type.toString());
        node.put("basePrice", basePrice);
        node.put("registrationNumber", registrationNumber);
        return node;
    }
}

