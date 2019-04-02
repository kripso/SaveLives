package Controller;

import Database.Data;
import View.LoginScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class UserController {


    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;

    public UserController(){

    }
    @FXML
    public void initialize(){
        UsernameTxtF.setText(Data.getInstance().user.getUserName());
        PasswordTxtF.setText(Data.getInstance().user.getPassword());
        OccupationTxtF.setText(Data.getInstance().user.getOccupation());
    }

    public void LogoutPressed() throws Exception {
        Controller.SetScene();
    }
}
