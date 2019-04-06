package users;

import Model.AbstractUser;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetUserInfo {

    public ArrayList<AbstractUser> users() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));
        ArrayList<AbstractUser> abstractUsers = (ArrayList<AbstractUser>) in.readObject();
        in.close();
        return abstractUsers;
    }
}
