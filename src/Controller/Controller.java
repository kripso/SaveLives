package Controller;

import View.LoginScreen;
import View.UserScreen;
import javafx.stage.Stage;

public class Controller {
    private static Stage PrimaryStage = new Stage();

    public Controller() {

    }

    public static void SetScene(String ActiveScene) throws Exception {
        if (ActiveScene == "LoginScene") {
            new UserScreen(PrimaryStage);
        } else if (ActiveScene == "UserScene") {
            new LoginScreen(PrimaryStage);
        }
    }

    public static void SetScene() throws Exception {
        new LoginScreen(PrimaryStage);
    }
}
