package market.db;

import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */

public class User {

    private UUID uuid;
    private String userName;
    private String email;
    private String firstName;
    private String secondName;
    private String lastName;
    private String address;

    public String getUserName() {
        return userName;
    }

    public String getEmail() {
        return email;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public String getThirdName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    /** Конструктор, написанный вручную для пользователей */
    public User(UUID uuid, String userName, String email, String firstName, String secondName, String thirdName, String address) {
        this.uuid = uuid;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = thirdName;
        this.address = address;
    }

}
