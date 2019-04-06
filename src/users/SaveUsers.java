package users;

import Model.AbstractUser;

import java.io.*;
import java.util.ArrayList;

public class SaveUsers {

    public static void users(ArrayList<AbstractUser> abstractUsers) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(abstractUsers);
        out.close();
    }

    public static void users(AbstractUser abstractUser) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<AbstractUser> abstractUsers = (ArrayList<AbstractUser>) in.readObject();
        abstractUsers.add(abstractUser);
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(abstractUsers);
        out.close();
    }

    public static void updateUserInfo(AbstractUser currentUser) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<AbstractUser> users = (ArrayList<AbstractUser>) in.readObject();

        for (AbstractUser abstractUser : users) {
            if (currentUser.getUserName().equals(abstractUser.getUserName())){
                abstractUser.setUser(currentUser);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
}
