package Model;

import javafx.beans.property.SimpleStringProperty;

public class SearchInfo {

    private final SimpleStringProperty userName;
    private final SimpleStringProperty address;
    private final SimpleStringProperty bloodTYpe;
    private final SimpleStringProperty bloodPlasma;
    private final SimpleStringProperty boneMarrow;

    public SearchInfo(String userName,String address,String bloodTYpe, String bloodPlasma, String boneMarrow) {
        this.userName = new SimpleStringProperty(userName);
        this.address = new SimpleStringProperty(address);
        this.bloodTYpe = new SimpleStringProperty(bloodTYpe);
        this.bloodPlasma = new SimpleStringProperty(bloodPlasma);
        this.boneMarrow = new SimpleStringProperty(boneMarrow);
    }

    public String getUserName() {
        return userName.get();
    }

    public void setUserName(String userName) {
        this.userName.set(userName);
    }

    public String getAddress() {
        return address.get();
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public String getBloodTYpe() {
        return bloodTYpe.get();
    }

    public void setBloodTYpe(String bloodTYpe) {
        this.bloodTYpe.set(bloodTYpe);
    }

    public String getBloodPlasma() {
        return bloodPlasma.get();
    }

    public void setBloodPlasma(String bloodPlasma) {
        this.bloodPlasma.set(bloodPlasma);
    }

    public String getBoneMarrow() {
        return boneMarrow.get();
    }

    public void setBoneMarrow(String boneMarrow) {
        this.boneMarrow.set(boneMarrow);
    }
}
