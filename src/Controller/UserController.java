package Controller;

import Database.Data;
import View.LoginScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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

    public UserController(){

    }
    @FXML
    public void initialize(){
        UsernameTxtF.setText(Data.getInstance().user.getUserName());
        PasswordTxtF.setText(Data.getInstance().user.getPassword());
        OccupationTxtF.setText(Data.getInstance().user.getOccupation());
        DonorCheckBox.setSelected(Data.getInstance().user.getDonor());

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
            Data.getInstance().user.setDonor(false);
            SaveUsers.users(Data.getInstance().user,false);
            TabPane.getTabs().remove(DonorTab);
        }else {
            Data.getInstance().user.setDonor(true);
            SaveUsers.users(Data.getInstance().user,true);
            TabPane.getTabs().add(DonorTab);
        }
    }
}
