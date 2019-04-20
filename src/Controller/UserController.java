package Controller;

import Database.Data;
import Model.PersonalInfo;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import users.SavePersonalInfo;
import users.SaveUsers;

import java.io.IOException;

public class UserController {

    public javafx.scene.control.TabPane TabPane;

    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorCheckBox;
    public Tab PersonalInfo;
    public Tab UserTab;

    public TextField Address;
    public TextField Email;
    public TextField PhoneNumber;
    public TextField Name;
    public TextField Surname;

    public User user = (User) Data.getInstance().abstractUser;
    public PersonalInfo personalInfo = Data.getInstance().personalInfo;

    public UserController(){

    }
    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        UsernameTxtF.setText(user.getUserName());
        PasswordTxtF.setText(user.getPassword());
        OccupationTxtF.setText(user.getOccupation());
        DonorCheckBox.setSelected(user.getDonor());

        Name.setText(personalInfo.getName());
        Surname.setText(personalInfo.getSurname());
        Address.setText(personalInfo.getAddress());
        Email.setText(personalInfo.getEmail());
        PhoneNumber.setText(personalInfo.getPhoneNum());

        UserTab.setClosable(false);

        if (!DonorCheckBox.isSelected()){
            TabPane.getTabs().remove(PersonalInfo);
        }
    }

    public void LogoutPressed() throws Exception {
        Controller.SetScene();
    }

    public void DonorCheckBoxChecked(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (!DonorCheckBox.isSelected()){
            Data.getInstance().abstractUser.setDonor(false);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser,UsernameTxtF.getText());
            TabPane.getTabs().remove(PersonalInfo);
        }else {
            Data.getInstance().abstractUser.setDonor(true);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser,UsernameTxtF.getText());
            TabPane.getTabs().add(1,PersonalInfo);
        }
        user.setDonor(Data.getInstance().abstractUser.getDonor());
    }

    public void usernameOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {

        SaveUsers.updateUserInfo(user,UsernameTxtF.getText());
        user.setUserName(UsernameTxtF.getText());
        Data.getInstance().abstractUser.setUserName(UsernameTxtF.getText());
    }

    public void passwordOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setPassword(PasswordTxtF.getText());
        Data.getInstance().abstractUser.setPassword(PasswordTxtF.getText());
        SaveUsers.updateUserInfo(user,UsernameTxtF.getText());
    }

    public void occupationOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setOccupation(OccupationTxtF.getText());
        Data.getInstance().abstractUser.setOccupation(OccupationTxtF.getText());
        SaveUsers.updateUserInfo(user,UsernameTxtF.getText());
    }

    public void addInformationPressed(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(),Name.getText(),Surname.getText(),Address.getText(),Email.getText(),PhoneNumber.getText());
        SavePersonalInfo.donors(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
    }
}
