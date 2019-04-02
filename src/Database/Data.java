package Database;

import Model.User;

public class Data {
    private static Data ourInstance = new Data();
    public User user;
    public static Data getInstance() {
        return ourInstance;
    }

    public Data() {
    }
}
