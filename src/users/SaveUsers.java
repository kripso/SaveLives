package users;

import Model.User;

import java.io.*;
import java.util.ArrayList;

public class SaveUsers {

    public static void users(ArrayList<User> users) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
    public static void users(User user) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<User> users = (ArrayList<User>) in.readObject();
        users.add(user);
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
    public static void users(User user,boolean donor) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<User> users = (ArrayList<User>) in.readObject();

        for (User userName : users) {
            if (user.getUserName().equals(userName.getUserName())){
                userName.setDonor(donor);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
}
