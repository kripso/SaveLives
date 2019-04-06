package Model;

public class Nurse extends User {

    private String userName;
    private String password;
    private String occupation;
    private boolean donor;


    public Nurse(String userName, String password, String occupation, boolean donor) {
        super(userName, password, occupation, donor);
    }
}
