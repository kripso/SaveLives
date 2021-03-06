package Model.DataManagement.SaveData;

import Model.Database.Data;
import Model.AbstractUser;

import java.io.*;
import java.util.ArrayList;
/**
 * olohou tejto clasy je vytvorit upravit a prepisat serializeble zlosky s prihlasovacimi udajmi o pouzivateloch
 */
public class SaveUsers {
    /**
     * tato metoda sa spusta pri prvotnom vygenerovani uzivatelov
     * @param abstractUsers vsetky udaje s uzivatelmi
     */
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

    public static void updateUserInfo(AbstractUser currentUser,String username) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<AbstractUser> users = (ArrayList<AbstractUser>) in.readObject();

        for (AbstractUser abstractUser : users) {
            if (Data.getInstance().abstractUser.getUserName().equals(abstractUser.getUserName())){
                currentUser.setUserName(username);
                abstractUser.setUser(currentUser);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
    public static void updateUserInfo(AbstractUser currentUser,boolean contribution) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("UserInfo.out"));

        ArrayList<AbstractUser> users = (ArrayList<AbstractUser>) in.readObject();

        for (AbstractUser abstractUser : users) {
            if (abstractUser.getUserName().equals(currentUser.getUserName())){
                currentUser.setUserName(currentUser.getUserName());
                abstractUser.setContribution(contribution);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("UserInfo.out"));
        out.writeObject(users);
        out.close();
    }
}
