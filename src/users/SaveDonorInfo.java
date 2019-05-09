package users;

import Database.Data;
import Model.DonorInfo;
import Model.MyError;
import Model.PersonalInfo;

import java.io.*;
import java.util.ArrayList;

public class SaveDonorInfo {

    public static void donorInfo(ArrayList<DonorInfo> donorInfos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(donorInfos);
        out.close();
    }

    public static void updateDonorInfo(DonorInfo currentUser,String username) throws ClassNotFoundException, IOException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));

        ArrayList<DonorInfo> users = (ArrayList<DonorInfo>) in.readObject();

        for (DonorInfo userInfo : users) {
            if (Data.getInstance().donorInfo.getUsername().equals(userInfo.getUsername())){
                currentUser.setUsername(username);
                userInfo.setDonorInfo(currentUser);
            }
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(users);
        out.close();
    }
    public static void donorInfo(DonorInfo donorInfo) throws ClassNotFoundException, IOException {
        Boolean InfoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));

        ArrayList<DonorInfo> donorInfos = (ArrayList<DonorInfo>) in.readObject();
        in.close();

        for (DonorInfo tmpdonor : donorInfos) {
            if (donorInfo.getUsername().equals(tmpdonor.getUsername())){
                InfoWasUpdated = true;
                tmpdonor.setDonorInfo(donorInfo);
            }
        }
        if (InfoWasUpdated==false){
            donorInfos.add(donorInfo);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(donorInfos);
        out.close();
    }

    public static void addDonorInfo(DonorInfo currentUser,String username) throws ClassNotFoundException, IOException, MyError {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));
        boolean changed = false;
        ArrayList<DonorInfo> users = (ArrayList<DonorInfo>) in.readObject();

        for (DonorInfo userInfo : users) {
            if (username.equals(userInfo.getUsername())){
                changed = true;
                currentUser.setUsername(username);
                userInfo.setDonorInfo(currentUser);
            }
        }
        if (!changed){
            throw new MyError(currentUser.getUsername());
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(users);
        out.close();
    }
}
