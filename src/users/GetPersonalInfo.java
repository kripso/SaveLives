package users;

import Model.PersonalInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetPersonalInfo {

    public ArrayList<PersonalInfo> users() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));
        ArrayList<PersonalInfo> personalInfos = (ArrayList<PersonalInfo>) in.readObject();
        in.close();
        return personalInfos;
    }
}

