package models;


import io.ebean.Finder;
import io.ebean.Model;

import javax.persistence.*;
import java.io.Serializable;

/*Users:
* User Model is replication of real world users
* It contains user properties
* */
@Entity
@Table
public class Users extends Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private long id;

    private String firstName;

    private String lastName;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                '}';
    }

    public static final Finder<Long, Users> find = new Finder<Long, Users>(Users.class) {
    };
}
