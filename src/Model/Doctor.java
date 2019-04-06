package Model;

public class Doctor extends Nurse {

    private String userName;
    private String password;
    private String occupation;
    private boolean donor;

    public Doctor(String userName, String password, String occupation, boolean donor) {
        super(userName,password,occupation,donor);
    }

}
