package Controller;

import Database.Data;
import Model.DonorInfo;
import Model.MyError;
import Model.PersonalInfo;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import users.SaveDonorInfo;
import users.SavePersonalInfo;
import java.io.IOException;
/**
 * <h1>NurseController</h1>
 * NurseController je uceny pre Sestricky a spolupatricne pracuje s danym view
 * ma navyse nikolko funkcii oproti userovi
 * @author  Roland Rajcsanyi
 */
public class NurseController extends UserController{
    /**
     * inicializacie dodatocnych textfieldov ktore niesu spristupnene userovy takisto aj s dvomi tabmi
     * a pridane inicializovanie dat o darcovskych infomaciach koli ich spracovaniu
     */
    public TextField hospital;

    public TextField usernameOfPatient;
    public TextField addBloodType;
    public TextField addPlasmaRHD;
    public TextField addBoneMarrowHLA;
    
    public TextField bloodType;
    public TextField plasmaRHD;
    public TextField boneMarrowHLA;

    private DonorInfo donorInfo = Data.getInstance().donorInfo;

    public Button addPersonalDonorInfoButton;
    public Button addPatientDonorInfoButton;

    public NurseController() throws IOException, ClassNotFoundException {
        super();
    }
    /**
     * nastavenie dodatocnych textfieldov
     * a pridade dva setOnAction event handleri pre pridanie Darcovskych informacii o sebe a pacientoch
     */
    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        super.initialize();
        if (donorInfo != null){
            bloodType.setText(Data.getInstance().donorInfo.getBloodTYpe());
            plasmaRHD.setText(Data.getInstance().donorInfo.getBloodPlasma());
            boneMarrowHLA.setText(Data.getInstance().donorInfo.getBoneMarrow());
            hospital.setText(Data.getInstance().personalInfo.getHospital());
        }
        addPatientDonorInfoButton.setOnAction(event ->{
            try {
                addPatientDonorInfo();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
        addPersonalDonorInfoButton.setOnAction(event -> {
            try {
                addPersonalDonorInfo();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });
    }
    /**
     * overridnuta funkcia koli pridanej funkcionalite
     * kazdy doktor a sestricka maju pridany textfield na urcenie nemocnice v ktorej pracuju
     * dalej funkcia zistuje ci prave pracuje Doctor alebo sestricka a ked pracuje doctor znovu nastavy tabulku koli zmenenym informaciam
     */
    @Override
    public void addInformationPressed() throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(), name.getText(), surname.getText(), address.getText(), email.getText(), phoneNumber.getText(), hospital.getText());
        SavePersonalInfo.personalInfo(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
        if(this instanceof DoctorController){
            setUpTableView();
        }
    }
    /**
     * nastavenie osobnych darcovskych udajov
     */
    public void addPersonalDonorInfo() throws IOException, ClassNotFoundException {
        DonorInfo donorInfo = new DonorInfo(Data.getInstance().abstractUser.getUserName(), bloodType.getText(), plasmaRHD.getText(), boneMarrowHLA.getText());
        SaveDonorInfo.updateDonorInfo(donorInfo,Data.getInstance().abstractUser.getUserName());
        Data.getInstance().donorInfo = donorInfo;
        if(this instanceof DoctorController){
            setUpTableView();
        }
    }
    /**
     * tato fukncia nastavuje darcovske informacie pouzivatelovi s usernamom ktory zada sestricka alebo doktor v programe
     */
    public void addPatientDonorInfo() throws IOException, ClassNotFoundException {
        try {
            DonorInfo donorInfo = new DonorInfo(usernameOfPatient.getText(), addBloodType.getText(), addPlasmaRHD.getText(), addBoneMarrowHLA.getText());
            SaveDonorInfo.addDonorInfo(donorInfo, usernameOfPatient.getText());
            if(this instanceof DoctorController){
                setUpTableView();
            }
        } catch (MyError myError) {
            myError.UserNotFoundAlert();
        }
    }
    /**
     * inicializovanie fukncie na nastavenie dat v tabulke
     * namiesto override na funkciu addPersonalDonorInfo a addInformationPressed v DoctorController som sa rozhodol ist tymto smerom
     * na usetrenie riadkov kodu a zbytocne prepisovanie fukncii
     */
    public void setUpTableView() throws IOException, ClassNotFoundException{
    }
}
