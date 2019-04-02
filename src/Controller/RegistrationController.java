package Controller;

import Database.Data;
import Model.User;
import View.LoginScreen;
import View.NurseScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import users.GetUserInfo;
import users.SaveUsers;

public class RegistrationController {


    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorChecked;


    GetUserInfo getUserInfo = new GetUserInfo();
    public RegistrationController(){

    }

    public void RegisterPressed() throws Exception {
        if(!UsernameTxtF.getText().equals("")&&!PasswordTxtF.getText().equals("")&&!OccupationTxtF.getText().equals("")){
            User user = new User(UsernameTxtF.getText(),PasswordTxtF.getText(),OccupationTxtF.getText(),DonorChecked.isSelected());
            SaveUsers.users(user);
            Data.getInstance().user = user;
            if(OccupationTxtF.getText().equals("Nurse")){
                Controller.SetScene(NurseScreen.getscene());
            }else {
                Controller.SetScene(UserScreen.getscene());
            }
        }

    }

    public void Registration(MouseEvent mouseEvent) {
        System.out.println("ahoj");
    }

    public void LoginPressed(ActionEvent actionEvent) throws Exception {
        Controller.SetScene(LoginScreen.getscene());

    }
}
