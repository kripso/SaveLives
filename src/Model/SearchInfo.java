package Model;

import java.io.Serializable;

public class SearchInfo implements Serializable {


    private String userName;
    private String address;
    private String bloodTYpe;
    private String bloodPlasma;
    private String boneMarrow;

    public SearchInfo(String userName,String address,String bloodTYpe, String bloodPlasma, String boneMarrow) {
        this.userName=userName;
        this.address=address;
        this.bloodTYpe=bloodTYpe;
        this.bloodPlasma=bloodPlasma;
        this.boneMarrow=boneMarrow;
    }

    public void setDonorInfo(SearchInfo donorInfo){

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBloodTYpe() {
        return bloodTYpe;
    }

    public void setBloodTYpe(String bloodTYpe) {
        this.bloodTYpe = bloodTYpe;
    }

    public String getBloodPlasma() {
        return bloodPlasma;
    }

    public void setBloodPlasma(String bloodPlasma) {
        this.bloodPlasma = bloodPlasma;
    }

    public String getBoneMarrow() {
        return boneMarrow;
    }

    public void setBoneMarrow(String boneMarrow) {
        this.boneMarrow = boneMarrow;
    }
}
