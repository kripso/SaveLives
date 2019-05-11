package Model;

import java.io.Serializable;

public class User extends AbstractUser {

    public User(String userName, String password, String occupation, boolean donor, boolean contribution) {
        super(userName,password,occupation,donor,contribution);
    }

}
