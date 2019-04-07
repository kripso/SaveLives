package Controller;

import Database.Data;
import Model.PersonalInfo;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import users.SavePersonalInfo;
import users.SaveUsers;

import java.io.IOException;

public class NurseController extends UserController {

    public TextField Address;
    public TextField Email;
    public TextField PhoneNumber;
    public TextField Name;
    public TextField Surname;
    public TextField Hospital;

    public NurseController(){

    }

    @FXML
    public void initialize(){
        super.initialize();
        Hospital.setText(Data.getInstance().personalInfo.getHospital());

    }

    public void addInformationPressed(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(),Name.getText(),Surname.getText(),Address.getText(),Email.getText(),PhoneNumber.getText(),Hospital.getText());
        SavePersonalInfo.donors(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
    }
}
