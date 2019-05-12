package Model.DataManagement.SaveData;

import Alerts.MyAlerts;
import Model.Database.Data;
import Model.PersonalInfo;

import java.io.*;
import java.util.ArrayList;
/**
 * olohou tejto clasy je vytvorit upravit a prepisat serializeble zlosky s osobnymi udajmi o pouzivateloch
 */
public class SavePersonalInfo {
    /**
     * tato metoda sa spusta pri prvotnom vygenerovani uzivatelov
     * @param personalInfos vsetky udaje s uzivatelmi
     */
    public static void personalInfo(ArrayList<PersonalInfo> personalInfos) throws IOException {
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(personalInfos);
        out.close();
    }
    /**
     * prepisanie uz nahratych udajov v personalInfo na aktualne s prislusnymi parametrami
     * @param personalInfo user s novymi udajmi
     */
    public static void personalInfo(PersonalInfo personalInfo) throws ClassNotFoundException, IOException {
        boolean infoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("personalInfoTab.out"));

        ArrayList<PersonalInfo> personalInfos = (ArrayList<PersonalInfo>) in.readObject();
        in.close();

        for (PersonalInfo tmpdonor : personalInfos) {
            if (personalInfo.getUserName().equals(tmpdonor.getUserName())){
                infoWasUpdated = true;
                tmpdonor.setPersonalInfo(personalInfo);
            }
        }
        if (!infoWasUpdated){
            personalInfos.add(personalInfo);
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(personalInfos);
        out.close();
    }
    /**
     * prepisanie uz nahratych udajov v osobnych informaciach na aktualne s prislusnymi parametrami
     * @param currentUser user s novymi udajmi
     * @param username username
     * @throws MyAlerts ked sa user nenajde
     */
    public static void updatePersonalInfo(PersonalInfo currentUser,String username) throws ClassNotFoundException, IOException, MyAlerts {
        boolean infoWasUpdated = false;
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("personalInfoTab.out"));

        ArrayList<PersonalInfo> users = (ArrayList<PersonalInfo>) in.readObject();

        for (PersonalInfo userInfo : users) {
            if (Data.getInstance().personalInfo.getUserName().equals(userInfo.getUserName())){
                infoWasUpdated = true;
                currentUser.setUserName(username);
                userInfo.setPersonalInfo(currentUser);
            }
        }
        if (!infoWasUpdated){
            throw new MyAlerts(currentUser.getUserName());
        }
        in.close();

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("personalInfoTab.out"));
        out.writeObject(users);
        out.close();

    }
}
