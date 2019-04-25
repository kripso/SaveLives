package Model;

import java.io.Serializable;

public class PersonalInfo implements Serializable {

    private String userName;
    private String name;
    private String surname;
    private String address;
    private String email;
    private String phoneNum;
    private String hospital;

    public PersonalInfo(String userName, String name, String surname, String address, String email, String phoneNum) {
        this.userName=userName;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.email=email;
        this.phoneNum=phoneNum;
    }

    public PersonalInfo(String userName, String name, String surname, String address, String email, String phoneNum,String hospital) {
        this.userName=userName;
        this.name=name;
        this.surname=surname;
        this.address=address;
        this.email=email;
        this.phoneNum=phoneNum;
        this.hospital=hospital;
    }

    public PersonalInfo(String userName) {
        this.userName=userName;
    }


    public void setPersonalInfo(PersonalInfo personalInfo){
        this.userName = personalInfo.userName;
        this.name = personalInfo.name;
        this.surname = personalInfo.surname;
        this.address = personalInfo.address;
        this.email = personalInfo.email;
        this.phoneNum = personalInfo.phoneNum;
        this.hospital = personalInfo.hospital;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
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
