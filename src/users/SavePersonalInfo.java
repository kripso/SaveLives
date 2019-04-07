package users;

import Model.PersonalInfo;

import java.io.*;
import java.util.ArrayList;

public class SavePersonalInfo {

    public static void donors(ArrayList<PersonalInfo> personalInfos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(personalInfos);
        out.close();
    }

    public static void donors(PersonalInfo personalInfo) throws ClassNotFoundException, IOException {
        Boolean InfoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));

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

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(personalInfos);
        out.close();
    }
}
