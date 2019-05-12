package Model.DataManagement.SaveData;

import Model.Database.Data;
import Model.DonorInfo;
import Alerts.MyAlerts;

import java.io.*;
import java.util.ArrayList;

/**
 * olohou tejto clasy je vytvorit upravit a prepisat serializeble zlosky s darcovskymi udajmi o pouzivateloch
 */
public class SaveDonorInfo {
    /**
     * tato metoda sa spusta pri prvotnom vygenerovani uzivatelov
     * @param donorInfos vsetky udaje s uzivatelmi
     */
    public static void donorInfo(ArrayList<DonorInfo> donorInfos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(donorInfos);
        out.close();
    }

    /**
     * prepisanie uz nahratych udajov v DonorInfo na aktualne s prislusnymi parametrami
     * @param currentUser user s novymi udajmi
     * @param username username
     */
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
        boolean InfoWasUpdated = false;
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

    /**
     * pridanie novych udajov o pouzivatelovi
     * @param currentUser
     * @param username
     * @throws MyAlerts vyhodi alert ak sa uzivatel nenajde
     */
    public static void addDonorInfo(DonorInfo currentUser,String username) throws ClassNotFoundException, IOException, MyAlerts {
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
            throw new MyAlerts(currentUser.getUsername());
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("DonorInfo.out"));
        out.writeObject(users);
        out.close();
    }
}
