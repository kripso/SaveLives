package Controller;

import Database.Data;
import Model.PersonalInfo;
import Model.User;
import View.UserNotification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import users.SavePersonalInfo;
import users.SaveUsers;
import java.io.IOException;

public class UserController {

    public javafx.scene.control.TabPane tabPane;

    public TextField usernameTxtF;
    public TextField passwordTxtF;
    public TextField occupationTxtF;
    public CheckBox donorCheckBox;
    public Tab personalInfoTab;
    public Tab userTab;

    public TextField address;
    public TextField email;
    public TextField phoneNumber;
    public TextField name;
    public TextField surname;

    public User user = (User) Data.getInstance().abstractUser;
    public PersonalInfo personalInfo = Data.getInstance().personalInfo;
    public Button addInformationButton;

    public UserController(){
        System.out.println(user.isContribution());
        if(user.isContribution()){
            new UserNotification();
        }
    }

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        usernameTxtF.setText(user.getUserName());
        passwordTxtF.setText(user.getPassword());
        occupationTxtF.setText(user.getOccupation());
        donorCheckBox.setSelected(user.getDonor());

        name.setText(personalInfo.getName());
        surname.setText(personalInfo.getSurname());
        address.setText(personalInfo.getAddress());
        email.setText(personalInfo.getEmail());
        phoneNumber.setText(personalInfo.getPhoneNum());

        userTab.setClosable(false);

        if (!donorCheckBox.isSelected()){
            tabPane.getTabs().remove(personalInfoTab);
        }

       addInformationButton.setOnAction(event -> {
           try {
               addInformationPressed();
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
       });
    }

    public void LogoutPressed() throws Exception {
        Controller.SetScene();
    }

    public void DonorCheckBoxChecked(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (!donorCheckBox.isSelected()){
            Data.getInstance().abstractUser.setDonor(false);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser, usernameTxtF.getText());
            tabPane.getTabs().remove(personalInfoTab);
        }else {
            Data.getInstance().abstractUser.setDonor(true);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser, usernameTxtF.getText());
            tabPane.getTabs().add(1, personalInfoTab);
        }
        user.setDonor(Data.getInstance().abstractUser.getDonor());
    }

    public void usernameOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
        SavePersonalInfo.updatePersonalInfo(personalInfo, usernameTxtF.getText());
        user.setUserName(usernameTxtF.getText());
        personalInfo.setUserName(usernameTxtF.getText());
        Data.getInstance().abstractUser.setUserName(usernameTxtF.getText());
        Data.getInstance().personalInfo.setUserName(usernameTxtF.getText());
    }

    public void passwordOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setPassword(passwordTxtF.getText());
        Data.getInstance().abstractUser.setPassword(passwordTxtF.getText());
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
    }

    public void occupationOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setOccupation(occupationTxtF.getText());
        Data.getInstance().abstractUser.setOccupation(occupationTxtF.getText());
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
    }

    public void addInformationPressed() throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(), name.getText(), surname.getText(), address.getText(), email.getText(), phoneNumber.getText());
        SavePersonalInfo.personalInfo(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
    }
}
