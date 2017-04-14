package market.db;

import java.util.UUID;

/**
 * Created by Троицкий Дмитрий on 14.04.2017.
 */

public class User {

    private UUID id;
    private String userName;
    private String email;
    private String firstName;
    private String secondName;
    private String thirdName;
    private String adress;


    public UUID getId() {
        return id;
    }

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
        return thirdName;
    }

    public String getAdress() {
        return adress;
    }

    public User( String userName, String email, String firstName, String secondName, String thirdName, String adress) {
        this.id = id;
        this.userName = userName;
        this.email = email;
        this.firstName = firstName;
        this.secondName = secondName;
        this.thirdName = thirdName;
        this.adress = adress;
    }
}
