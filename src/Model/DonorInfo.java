package Model;

import java.io.Serializable;

public class DonorInfo implements Serializable {

    private String username;
    private String bloodTYpe;
    private String bloodPlasma;
    private String boneMarrow;

    public DonorInfo(String username,String bloodTYpe, String bloodPlasma, String boneMarrow) {
        this.username = username;
        this.bloodTYpe=bloodTYpe;
        this.bloodPlasma=bloodPlasma;
        this.boneMarrow=boneMarrow;

    }

    public void setDonorInfo(DonorInfo donorInfo){
        this.bloodTYpe=donorInfo.bloodTYpe;
        this.bloodPlasma=donorInfo.bloodPlasma;
        this.boneMarrow=donorInfo.boneMarrow;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
