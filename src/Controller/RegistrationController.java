package Controller;

import Database.Data;
import Model.DonorInfo;
import Model.PersonalInfo;
import Model.User;
import View.DoctorScreen;
import View.LoginScreen;
import View.NurseScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import users.SaveDonorInfo;
import users.SavePersonalInfo;
import users.SaveUsers;
/**
 * <h1>RegistrationController</h1>
 * Controller ma za ulohu vytvorit pouzivatela a zapnut patricne View podla toho kto sa prihlasi
 * @author  Roland Rajcsanyi
 */
public class RegistrationController {
    /**
     * inicializovanie textfieldov
     */
    public TextField usernameTxtF;
    public PasswordField passwordTxtF;
    public TextField occupationTxtF;
    public CheckBox donorChecked;


    public RegistrationController(){

    }

    /**
     * Registracia uzivatela inicializovanie jeho dat a informacii o nom
     * nasledne podla povolania sa zapne patricna scena
     */
    public void RegisterPressed() throws Exception {
        if(!usernameTxtF.getText().equals("")&&!passwordTxtF.getText().equals("")&&!occupationTxtF.getText().equals("")){
            User user = new User(usernameTxtF.getText(), passwordTxtF.getText(), occupationTxtF.getText(), donorChecked.isSelected(),false);
            PersonalInfo personalInfo = new PersonalInfo(usernameTxtF.getText(),"","","","","");
            DonorInfo donorInfo = new DonorInfo(usernameTxtF.getText(),"","","");
            SaveUsers.users(user);
            SavePersonalInfo.personalInfo(personalInfo);
            SaveDonorInfo.donorInfo(donorInfo);

            Data.getInstance().abstractUser = user;
            Data.getInstance().personalInfo = personalInfo;
            Data.getInstance().donorInfo = donorInfo;

            if(occupationTxtF.getText().equals("Nurse")){
                Controller.SetScene(NurseScreen.getscene());
            }else if(occupationTxtF.getText().equals("Doctor")){
                Controller.SetScene(DoctorScreen.getscene());
            }else {
                Controller.SetScene(UserScreen.getscene());
            }
        }
    }

    /**
     * prechod na login scenu
     */
    public void LoginPressed(ActionEvent actionEvent) throws Exception {
        Controller.SetScene(LoginScreen.getscene());
    }
}
