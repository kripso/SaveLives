package Database;

import Model.AbstractUser;
import Model.Donor;

public class Data {
    private static Data ourInstance = new Data();
    public AbstractUser abstractUser;
    public Donor donor;
    public static Data getInstance() {
        return ourInstance;
    }

    public Data() {
    }
}
