package Controller;

import View.*;
import javafx.stage.Stage;
import users.PersonalInfoGenerator;
import users.SavePersonalInfo;
import users.SaveUsers;
import users.UsersGenerator;

import java.io.IOException;

public class Controller {
    private static Stage PrimaryStage = new Stage();

    public Controller() throws IOException, ClassNotFoundException {
        UsersGenerator usersGenerator = new UsersGenerator();
        PersonalInfoGenerator personalInfoGenerator = new PersonalInfoGenerator();
        SaveUsers.users(usersGenerator.generate());
        SavePersonalInfo.donors(personalInfoGenerator.generate(UsersGenerator.username));
    }

    public static void SetScene(String SetActiveScene) throws Exception {
        if (SetActiveScene == "UserScene") {
            new UserScreen(PrimaryStage);
        } else if (SetActiveScene == "NurseScene") {
            new NurseScreen(PrimaryStage);
        } else if (SetActiveScene == "DoctorScene") {
            new DoctorScreen(PrimaryStage);
        } else if (SetActiveScene == "LoginScene") {
            new LoginScreen(PrimaryStage);
        } else if (SetActiveScene == "RegistrationScene") {
            new RegistrationScreen(PrimaryStage);
        }
    }

    public static void SetScene() throws Exception {
        new LoginScreen(PrimaryStage);
    }
}
