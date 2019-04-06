package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import users.SaveUsers;

import java.io.IOException;

public class UserController {


    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorCheckBox;
    public Tab DonorTab;
    public javafx.scene.control.TabPane TabPane;
    public Tab UserTab;

    User user = (User) Data.getInstance().abstractUser;

    public UserController(){

    }
    @FXML
    public void initialize(){
        UsernameTxtF.setText(user.getUserName());
        PasswordTxtF.setText(user.getPassword());
        OccupationTxtF.setText(user.getOccupation());
        DonorCheckBox.setSelected(user.getDonor());

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

}
