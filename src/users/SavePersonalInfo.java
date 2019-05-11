package users;

import Database.Data;
import Model.PersonalInfo;

import java.io.*;
import java.util.ArrayList;

public class SavePersonalInfo {

    public static void personalInfo(ArrayList<PersonalInfo> personalInfos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(personalInfos);
        out.close();
    }

    public static void personalInfo(PersonalInfo personalInfo) throws ClassNotFoundException, IOException {
        Boolean InfoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("personalInfoTab.out"));

        ArrayList<PersonalInfo> personalInfos = (ArrayList<PersonalInfo>) in.readObject();
        in.close();

        for (PersonalInfo tmpdonor : personalInfos) {
            if (personalInfo.getUserName().equals(tmpdonor.getUserName())){
                InfoWasUpdated = true;
                tmpdonor.setPersonalInfo(personalInfo);
            }
        }
        if (InfoWasUpdated==false){
            personalInfos.add(personalInfo);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(personalInfos);
        out.close();
    }

    public static void updatePersonalInfo(PersonalInfo currentUser,String username) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("personalInfoTab.out"));

        ArrayList<PersonalInfo> users = (ArrayList<PersonalInfo>) in.readObject();

        for (PersonalInfo userInfo : users) {
            if (Data.getInstance().personalInfo.getUserName().equals(userInfo.getUserName())){
                currentUser.setUserName(username);
                userInfo.setPersonalInfo(currentUser);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(users);
        out.close();

    }
}
