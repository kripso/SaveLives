package users;

import Model.UserModel;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;

public class SaveUsers {

    public static void users(ArrayList<UserModel> users) throws ClassNotFoundException, IOException {

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("d.out"));
        out.writeObject(users);
        out.close();


    }

}
