package Database;

import Model.AbstractUser;

public class Data {
    private static Data ourInstance = new Data();
    public AbstractUser abstractUser;
    public static Data getInstance() {
        return ourInstance;
    }

    public Data() {
    }
}
