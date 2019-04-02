package users;

import Model.User;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class SaveUsers {

    public static void users(ArrayList<User> users) throws ClassNotFoundException, IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }

}
