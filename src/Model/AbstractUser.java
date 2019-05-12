package Model;

import java.io.Serializable;

/**
 * abstractna treda pre prihlasovanie udaje o pouzivatelovi
 */
public abstract class AbstractUser implements Serializable {

    private String userName;
    private String password;
    private String occupation;
    private boolean donor;
    private boolean contribution;

    /**
     * inicializacia pouzivatela s patricnimy parametrami
     * @param userName
     * @param password
     * @param occupation
     * @param donor
     * @param contribution
     */
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

    /**
     * seteri a geteri pre pouzivatela
     */
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
