package users;

import Model.AbstractUser;
import Model.Donor;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class GetDonorInfo {

    public ArrayList<Donor> users() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));
        ArrayList<Donor> donors = (ArrayList<Donor>) in.readObject();
        in.close();
        return donors;
    }
}

