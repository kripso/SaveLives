package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.PersonalInfo;
import View.DoctorScreen;
import View.NurseScreen;
import View.RegistrationScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import users.GetPersonalInfo;
import users.GetUserInfo;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    public Label Registration;
    public PasswordField PasswordTxtF;
    public TextField UsernameTxtF;

    ArrayList<AbstractUser> users;
    ArrayList<PersonalInfo> personalInfos;

    GetUserInfo userInfo = new GetUserInfo();
    GetPersonalInfo personalInfo = new GetPersonalInfo();

    public LoginController() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        personalInfos = personalInfo.users();
    }

    public void LoginPressed() throws Exception {
        AbstractUser user = getUser(UsernameTxtF.getText(), PasswordTxtF.getText());
        PersonalInfo personalInfo = getPersonalInfo(UsernameTxtF.getText());
        if (user != null) {

            Data.getInstance().abstractUser = user;
            Data.getInstance().personalInfo = personalInfo;

            if (user.getOccupation().equals("Nurse")){
                Controller.SetScene(NurseScreen.getscene());
            }else if (user.getOccupation().equals("Doctor")){
                Controller.SetScene(DoctorScreen.getscene());
            }else {
                Controller.SetScene(UserScreen.getscene());
            }
        }
    }

    public AbstractUser getUser(String userName, String password) {
        for (AbstractUser abstractUser : users) {
            if (abstractUser.getUserName().equals(userName) && abstractUser.getPassword().equals(password)) {
                return abstractUser;
            }
        }
        return null;
    }
    public PersonalInfo getPersonalInfo(String userName) {
        for (PersonalInfo personalInfo : personalInfos) {
            if (personalInfo.getUserName().equals(userName)) {
                return personalInfo;
            }
        }
        return null;
    }
    public void Registration(MouseEvent mouseEvent) throws Exception {
        Controller.SetScene(RegistrationScreen.getscene());
    }

    public void MouseEntered(MouseEvent mouseEvent) {
        Registration.setTextFill(Color.BLUE);
    }

    public void MouseExited(MouseEvent mouseEvent) {
        Registration.setTextFill(Color.BLACK);
    }

    public void onEnter(ActionEvent actionEvent) throws Exception {
        LoginPressed();
    }
}
