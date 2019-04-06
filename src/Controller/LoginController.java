package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.Doctor;
import Model.Donor;
import Model.User;
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
import users.GetDonorInfo;
import users.GetUserInfo;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    public Label Registration;
    public PasswordField PasswordTxtF;
    public TextField UsernameTxtF;

    ArrayList<AbstractUser> users;
    ArrayList<Donor> donors;

    GetUserInfo userInfo = new GetUserInfo();
    GetDonorInfo donorInfo = new GetDonorInfo();

    public LoginController() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        donors = donorInfo.users();
    }

    public void LoginPressed() throws Exception {
        AbstractUser user = getUser(UsernameTxtF.getText(), PasswordTxtF.getText());
        Donor donor = getDonor(UsernameTxtF.getText());
        if (user != null) {

            Data.getInstance().abstractUser = user;
            Data.getInstance().donor = donor;

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
    public Donor getDonor(String userName) {
        for (Donor donor : donors) {
            if (donor.getUserName().equals(userName)) {
                return donor;
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
