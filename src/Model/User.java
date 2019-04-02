package Model;

import java.io.Serializable;

public class User implements Serializable {

    private String userName;
    private String password;
    private String occupation;

    public User(String userName, String password,String occupation) {
        this.userName = userName;
        this.password = password;
        this.occupation = occupation;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getUserName() {
        return userName;
    }
    public String getPassword() {
        return password;
    }
    public String getOccupation() {
        return occupation;
    }

}
