package View.Screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserScreen{

    public UserScreen(Stage PrimaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("UserScreen.fxml"));
        Scene scene = new Scene(root);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }

    public static String getscene(){
        return "UserScene";
    }
}
