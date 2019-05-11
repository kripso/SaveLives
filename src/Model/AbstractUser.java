package Model;

import java.io.Serializable;

public abstract class AbstractUser implements Serializable {

    private String userName;
    private String password;
    private String occupation;
    private boolean donor;
    private boolean contribution;

    public AbstractUser(String userName, String password, String occupation, boolean donor, boolean contribution) {
        this.userName = userName;
        this.password = password;
        this.occupation = occupation;
        this.donor = donor;
        this.contribution = contribution;
    }


    public void setUser(AbstractUser user){
        this.userName = user.userName;
        this.password = user.password;
        this.occupation = user.occupation;
        this.donor = user.donor;
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
    public void setDonor(boolean donor) {
        this.donor = donor;
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
    public boolean getDonor() {
        return donor;
    }


    public boolean isDonor() {
        return donor;
    }

    public boolean isContribution() {
        return contribution;
    }

    public void setContribution(boolean contribution) {
        this.contribution = contribution;
    }
}
