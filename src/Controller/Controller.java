package Controller;

import View.*;
import javafx.stage.Stage;
import users.*;

import java.io.IOException;

public class Controller {
    private static Stage PrimaryStage = new Stage();

    public Controller() throws IOException, ClassNotFoundException {
        UsersGenerator usersGenerator = new UsersGenerator();
        PersonalInfoGenerator personalInfoGenerator = new PersonalInfoGenerator();
        DonorInfoGenerator donorInfoGenerator = new DonorInfoGenerator();
        SaveDonorInfo.donorInfo(donorInfoGenerator.generate(UsersGenerator.username));
        SaveUsers.users(usersGenerator.generate());
        SavePersonalInfo.personalInfo(personalInfoGenerator.generate(UsersGenerator.username));
    }

    public static void SetScene(String SetActiveScene) throws Exception {
        if (SetActiveScene.equals("UserScene")) {
            new UserScreen(PrimaryStage);
        } else if (SetActiveScene.equals("NurseScene")) {
            new NurseScreen(PrimaryStage);
        } else if (SetActiveScene.equals("DoctorScene")) {
            new DoctorScreen(PrimaryStage);
        } else if (SetActiveScene.equals("LoginScene")) {
            new LoginScreen(PrimaryStage);
        } else if (SetActiveScene.equals("RegistrationScene")) {
            new RegistrationScreen(PrimaryStage);
        }
    }

    public static void SetScene() throws Exception {
        new LoginScreen(PrimaryStage);
    }
}
