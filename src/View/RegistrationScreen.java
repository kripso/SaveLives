package View;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class RegistrationScreen extends Parent {

    public TextField Password;
    public TextField Username;


    public RegistrationScreen(Stage PrimaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("RegistrationScreen.fxml"));
        Scene scene = new Scene(root);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    public static String getscene(){
        return "RegistrationScene";
    }

    public TextField getPassword() {
        return Password;
    }

    public TextField getUsername() {
        return Username;
    }

    public void setPassword(TextField password) {
        Password = password;
    }

    public void setUsername(TextField username) {
        Username = username;
    }
}
