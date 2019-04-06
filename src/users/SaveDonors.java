package users;

import Model.AbstractUser;
import Model.Donor;

import java.io.*;
import java.util.ArrayList;

public class SaveDonors {

    public static void donors(ArrayList<Donor> donors) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(donors);
        out.close();
    }

    public static void donors(Donor donor) throws ClassNotFoundException, IOException {
        Boolean InfoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));

        ArrayList<Donor> donors = (ArrayList<Donor>) in.readObject();
        in.close();

        for (Donor tmpdonor : donors) {
            if (donor.getUserName().equals(tmpdonor.getUserName())){
                InfoWasUpdated = true;
                tmpdonor.setDonor(donor);
            }
        }
        if (InfoWasUpdated==false){
            donors.add(donor);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(donors);
        out.close();
    }
}
