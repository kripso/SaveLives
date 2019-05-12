import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public void start(Stage PrimaryStage) throws Exception{
        new Controller();
        Controller.SetScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

