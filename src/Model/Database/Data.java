package Model.Database;

import Model.AbstractUser;
import Model.DonorInfo;
import Model.PersonalInfo;

/**
 * Data je zbernica dat s globalnym pristupom sem uklada program aktualne prihlaseneho pouzivatela a informacie o nom
 * su tu nainstacovane csetky potrebne metody
 */
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
