package Controller;

import View.LoginScreen;
import View.RegistrationScreen;
import View.UserScreen;
import javafx.stage.Stage;

public class Controller {
    private static Stage PrimaryStage = new Stage();

    public Controller() {

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
