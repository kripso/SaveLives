package Controller;

import Database.Data;
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
import users.SavePersonalInfo;
import users.SaveUsers;

public class RegistrationController {


    public TextField UsernameTxtF;
    public PasswordField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorChecked;


    public RegistrationController(){

    }

    public void RegisterPressed() throws Exception {
        if(!UsernameTxtF.getText().equals("")&&!PasswordTxtF.getText().equals("")&&!OccupationTxtF.getText().equals("")){
            User user = new User(UsernameTxtF.getText(),PasswordTxtF.getText(),OccupationTxtF.getText(),DonorChecked.isSelected());
            PersonalInfo personalInfo = new PersonalInfo(UsernameTxtF.getText(),"","","","","");

            SaveUsers.users(user);
            SavePersonalInfo.donors(personalInfo);

            Data.getInstance().abstractUser = user;
            Data.getInstance().personalInfo = personalInfo;

            if(OccupationTxtF.getText().equals("Nurse")){
                Controller.SetScene(NurseScreen.getscene());
            }else if(OccupationTxtF.getText().equals("Doctor")){
                Controller.SetScene(DoctorScreen.getscene());
            }else {
                Controller.SetScene(UserScreen.getscene());
            }
        }

    }

    public void LoginPressed(ActionEvent actionEvent) throws Exception {
        Controller.SetScene(LoginScreen.getscene());

    }
}
