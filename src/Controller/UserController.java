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


    public TextField Username;
    public TextField Password;
    public TextField Occupation;

    public UserController(){

    }
    @FXML
    public void initialize(){
        Username.setText(Data.getInstance().user.getUserName());
        Password.setText(Data.getInstance().user.getPassword());
    }

    public void LogoutPressed() throws Exception {
        Controller.SetScene();
    }
}
