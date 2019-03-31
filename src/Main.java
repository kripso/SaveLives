import Controller.Controller;
import View.LoginScreen;
import View.UserScreen;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage PrimaryStage) throws Exception{
        Controller.SetScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

