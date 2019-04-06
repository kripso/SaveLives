package Model;

import java.io.Serializable;

public class Donor implements Serializable {

    private String userName;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNum;

    public Donor(String userName,String name, String surname, String address,String email, String phoneNum) {
        this.userName=userName;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.email=email;
        this.phoneNum=phoneNum;
    }

    public Donor(String userName) {
        this.userName=userName;

    }
    public void setDonor(Donor donor){
        this.userName = donor.userName;
        this.name = donor.name;
        this.surname = donor.surname;
        this.address = donor.address;
        this.email = donor.email;
        this.phoneNum = donor.phoneNum;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String adress) {
        this.address = adress;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhonenum(String phonenum) {
        this.phoneNum = phonenum;
    }
}
