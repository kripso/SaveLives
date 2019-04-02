package Controller;

import Database.Data;
import View.LoginScreen;
import View.RegistrationScreen;
import View.UserScreen;
import javafx.stage.Stage;
import users.SaveUsers;
import users.UsersGenerator;

import java.io.IOException;

public class Controller {
    private static Stage PrimaryStage = new Stage();

    public Controller() throws IOException, ClassNotFoundException {
        UsersGenerator usersGenerator = new UsersGenerator();
        SaveUsers.users(usersGenerator.generate());
    }

    public static void SetScene(String SetActiveScene) throws Exception {
        if (SetActiveScene == "UserScene") {
            new UserScreen(PrimaryStage);
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
