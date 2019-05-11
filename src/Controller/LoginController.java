package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.DonorInfo;
import Model.MyError;
import Model.PersonalInfo;
import View.*;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import sun.plugin2.message.Message;
import users.GetDonorInfo;
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
    ArrayList<DonorInfo> donorInfos;

    GetUserInfo userInfo = new GetUserInfo();
    GetPersonalInfo personalInfo = new GetPersonalInfo();
    GetDonorInfo donorInfo = new GetDonorInfo();

    public LoginController() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        personalInfos = personalInfo.users();
        donorInfos = donorInfo.users();
    }

    public void LoginPressed() throws Exception {
        AbstractUser user;
        PersonalInfo personalInfo;
        DonorInfo donorInfo;

        try{
            user = getUser(UsernameTxtF.getText(), PasswordTxtF.getText());
            personalInfo = getPersonalInfo(UsernameTxtF.getText());
            donorInfo = getDonorInfo(UsernameTxtF.getText());

            if (user != null) {

                Data.getInstance().abstractUser = user;
                Data.getInstance().personalInfo = personalInfo;
                Data.getInstance().donorInfo = donorInfo;

                if (user.getOccupation().equals("Nurse")){
                    Controller.SetScene(NurseScreen.getscene());
                }else if (user.getOccupation().equals("Doctor")){
                    Controller.SetScene(DoctorScreen.getscene());
                }else {
                    Controller.SetScene(UserScreen.getscene());
                }
            }
        }catch(MyError myError){
            myError.UsernameNotFoundAlert();
        }
    }


    public AbstractUser getUser(String userName, String password) throws MyError{
        for (AbstractUser abstractUser : users) {
            if (abstractUser.getUserName().equals(userName) && abstractUser.getPassword().equals(password)) {
                return abstractUser;
            }
        }
        throw new MyError(UsernameTxtF.getText());
    }
    public PersonalInfo getPersonalInfo(String userName) {
        for (PersonalInfo personalInfo : personalInfos) {
            if (personalInfo.getUserName().equals(userName)) {
                return personalInfo;
            }
        }
        return null;
    }
    public DonorInfo getDonorInfo(String userName) {
        for (DonorInfo donorInfo : donorInfos) {
            if (donorInfo.getUsername().equals(userName)) {
                return donorInfo;
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
