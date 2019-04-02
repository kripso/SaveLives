package Model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String password;

    public User(String UserName, String Password) {
        this.userName = UserName;
        this.password = Password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }
}
