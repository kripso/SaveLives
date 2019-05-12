import Controller.Controller;
import javafx.application.Application;
import javafx.stage.Stage;

/**
 * treda Main len spusti hlavny controller a zapne scenu
 * kezde zapina scenu bez parametra program vie ze ma zapnut Login
 */
public class Main extends Application {

    public void start(Stage PrimaryStage) throws Exception{
        new Controller();
        Controller.SetScene();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

