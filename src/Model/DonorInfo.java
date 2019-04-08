package Model;

import java.io.Serializable;

public class DonorInfo implements Serializable {

    private String bloodTYpe;
    private String bloodPlasma;
    private String boneMarrow;

    public DonorInfo(String bloodTYpe, String bloodPlasma, String boneMarrow) {
        this.bloodTYpe=bloodTYpe;
        this.bloodPlasma=bloodPlasma;
        this.boneMarrow=boneMarrow;

    }

    public void setDonorInfo(DonorInfo donorInfo){
        this.bloodTYpe=donorInfo.bloodTYpe;
        this.bloodPlasma=donorInfo.bloodPlasma;
        this.boneMarrow=donorInfo.boneMarrow;
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
