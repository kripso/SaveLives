package Controller;

import Database.Data;
import Model.DonorInfo;
import Model.MyError;
import Model.PersonalInfo;
import View.UserNotFoundAlert;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import users.SaveDonorInfo;
import users.SavePersonalInfo;

import java.io.IOException;

public class NurseController extends UserController {

    public TextField Hospital;

    public TextField UsernameOfPatient;
    public TextField AddBloodType;
    public TextField AddPlasmaRHD;
    public TextField AddBoneMarrowHLA;
    
    public TextField BloodType;
    public TextField PlasmaRHD;
    public TextField BoneMarrowHLA;

    public DonorInfo donorInfo = Data.getInstance().donorInfo;

    public NurseController(){

    }

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        super.initialize();
        if (donorInfo != null){
            BloodType.setText(Data.getInstance().donorInfo.getBloodTYpe());
            PlasmaRHD.setText(Data.getInstance().donorInfo.getBloodPlasma());
            BoneMarrowHLA.setText(Data.getInstance().donorInfo.getBoneMarrow());
            Hospital.setText(Data.getInstance().personalInfo.getHospital());
        }
    }

    public void addInformationPressed(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(),Name.getText(),Surname.getText(),Address.getText(),Email.getText(),PhoneNumber.getText(),Hospital.getText());
        SavePersonalInfo.personalInfo(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
    }

    public void addPersonalDonorInfo(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        DonorInfo donorInfo = new DonorInfo(Data.getInstance().abstractUser.getUserName(),BloodType.getText(),PlasmaRHD.getText(),BoneMarrowHLA.getText());
        SaveDonorInfo.updateDonorInfo(donorInfo,Data.getInstance().abstractUser.getUserName());
        Data.getInstance().donorInfo = donorInfo;
    }

    public void addPatienDonorInfo(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        try {
            DonorInfo donorInfo = new DonorInfo(UsernameOfPatient.getText(),AddBloodType.getText(),AddPlasmaRHD.getText(),AddBoneMarrowHLA.getText());
            SaveDonorInfo.addDonorInfo(donorInfo,UsernameOfPatient.getText());
        } catch (MyError myError) {
            myError.UserNotFoundAlert(UsernameOfPatient.getText());
        }
    }
}
