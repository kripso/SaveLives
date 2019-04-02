package users;

import Model.User;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetUserInfo {

    public ArrayList<User> users() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));
        ArrayList<User> users = (ArrayList<User>) in.readObject();
        in.close();
        return users;
    }
}
