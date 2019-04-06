package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.Donor;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import users.SaveDonors;
import users.SaveUsers;

import java.io.IOException;

public class UserController {

    public javafx.scene.control.TabPane TabPane;

    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorCheckBox;
    public Tab DonorTab;
    public Tab UserTab;

    public TextField Address;
    public TextField Email;
    public TextField PhoneNumber;
    public TextField Name;
    public TextField Surname;

    private User user = (User) Data.getInstance().abstractUser;
    private Donor donor = (Donor) Data.getInstance().donor;

    public UserController(){

    }
    @FXML
    public void initialize(){
        UsernameTxtF.setText(user.getUserName());
        PasswordTxtF.setText(user.getPassword());
        OccupationTxtF.setText(user.getOccupation());
        DonorCheckBox.setSelected(user.getDonor());

        Name.setText(donor.getName());
        Surname.setText(donor.getSurname());
        Address.setText(donor.getAddress());
        Email.setText(donor.getEmail());
        PhoneNumber.setText(donor.getPhoneNum());

        UserTab.setClosable(false);

        if (!DonorCheckBox.isSelected()){
            TabPane.getTabs().remove(DonorTab);
        }
    }

    public void LogoutPressed() throws Exception {
        Controller.SetScene();
    }

    public void DonorCheckBoxChecked(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (!DonorCheckBox.isSelected()){
            Data.getInstance().abstractUser.setDonor(false);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser);
            TabPane.getTabs().remove(DonorTab);
        }else {
            Data.getInstance().abstractUser.setDonor(true);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser);
            TabPane.getTabs().add(1,DonorTab);
        }
        user.setDonor(Data.getInstance().abstractUser.getDonor());
    }

    public void usernameOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setUserName(UsernameTxtF.getText());
        Data.getInstance().abstractUser.setUserName(UsernameTxtF.getText());
        SaveUsers.users(user);
    }

    public void passwordOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setPassword(PasswordTxtF.getText());
        Data.getInstance().abstractUser.setPassword(PasswordTxtF.getText());
        SaveUsers.users(user);
    }

    public void occupationOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setOccupation(OccupationTxtF.getText());
        Data.getInstance().abstractUser.setOccupation(OccupationTxtF.getText());
        SaveUsers.users(user);
    }

    public void addInformationPressed(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        Donor donor = new Donor(Data.getInstance().abstractUser.getUserName(),Name.getText(),Surname.getText(),Address.getText(),Email.getText(),PhoneNumber.getText());
        SaveDonors.donors(donor);
        Data.getInstance().donor=donor;
    }
}
