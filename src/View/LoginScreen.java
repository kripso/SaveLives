package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class LoginScreen{

    public LoginScreen(Stage PrimaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("LoginScreen.fxml"));
        Scene scene = new Scene(root);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    public static String getscene(){
        return "LoginScene";
    }

}
