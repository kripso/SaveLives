package Database;

import Model.AbstractUser;
import Model.DonorInfo;
import Model.PersonalInfo;

public class Data {
    private static Data ourInstance = new Data();
    public AbstractUser abstractUser;
    public PersonalInfo personalInfo;
    public DonorInfo donorInfo;

    public static Data getInstance() {
        return ourInstance;
    }

    public Data() {
    }
}
