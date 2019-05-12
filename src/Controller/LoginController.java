package Controller;

import Model.Database.Data;
import Model.AbstractUser;
import Model.DonorInfo;
import Alerts.MyAlerts;
import Model.PersonalInfo;
import View.Screens.DoctorScreen;
import View.Screens.NurseScreen;
import View.Screens.RegistrationScreen;
import View.Screens.UserScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import Model.DataManagement.GetData.GetDonorInfo;
import Model.DataManagement.GetData.GetPersonalInfo;
import Model.DataManagement.GetData.GetUserInfo;

import java.io.IOException;
import java.util.ArrayList;
/**
 * <h1>LoginController</h1>
 * Controller ma za ulohu nastavovat patricne View podla toho kto sa prihlasi
 * @author  Roland Rajcsanyi
 */
public class LoginController {
    /**
     *
     */
    public Label registration;
    public PasswordField passwordTxtF;
    public TextField usernameTxtF;

    private ArrayList<AbstractUser> users;
    private ArrayList<PersonalInfo> personalInfos;
    private ArrayList<DonorInfo> donorInfos;

    public LoginController() throws IOException, ClassNotFoundException {
        GetUserInfo userInfo = new GetUserInfo();
        users = userInfo.users();
        GetPersonalInfo personalInfo = new GetPersonalInfo();
        personalInfos = personalInfo.users();
        GetDonorInfo donorInfo = new GetDonorInfo();
        donorInfos = donorInfo.users();
    }

    /**
     *
     * @throws Exception
     */
    public void LoginPressed() throws Exception {
        AbstractUser user;
        PersonalInfo personalInfo;
        DonorInfo donorInfo;

        try{
            user = getUser(usernameTxtF.getText(), passwordTxtF.getText());
            personalInfo = getPersonalInfo(usernameTxtF.getText());
            donorInfo = getDonorInfo(usernameTxtF.getText());

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
        }catch(MyAlerts myAlerts){
            myAlerts.UsernameNotFoundAlert();
        }
    }

    /**
     *
     * @param userName
     * @param password
     */
    private AbstractUser getUser(String userName, String password) throws MyAlerts {
        for (AbstractUser abstractUser : users) {
            if (abstractUser.getUserName().equals(userName) && abstractUser.getPassword().equals(password)) {
                return abstractUser;
            }
        }
        throw new MyAlerts(usernameTxtF.getText());
    }

    /**
     *
     * @param userName
     * @return
     */

    private PersonalInfo getPersonalInfo(String userName) {
        for (PersonalInfo personalInfo : personalInfos) {
            if (personalInfo.getUserName().equals(userName)) {
                return personalInfo;
            }
        }
        return null;
    }

    /**
     *
     * @param userName
     * @return
     */
    private DonorInfo getDonorInfo(String userName) {
        for (DonorInfo donorInfo : donorInfos) {
            if (donorInfo.getUsername().equals(userName)) {
                return donorInfo;
            }
        }
        return null;
    }

    /**
     *
     * @param mouseEvent
     */
    public void Registration(MouseEvent mouseEvent) throws Exception {
        Controller.SetScene(RegistrationScreen.getscene());
    }

    public void MouseEntered(MouseEvent mouseEvent) {
        registration.setTextFill(Color.BLUE);
    }

    public void MouseExited(MouseEvent mouseEvent) {
        registration.setTextFill(Color.BLACK);
    }

    public void onEnter(ActionEvent actionEvent) throws Exception {
        LoginPressed();
    }
}
