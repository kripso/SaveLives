package View.Screens;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DoctorScreen {

    public DoctorScreen(Stage PrimaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("DoctorScreen.fxml"));
        Scene scene = new Scene(root);

        PrimaryStage.setScene(scene);
        PrimaryStage.show();
    }
    public static String getscene(){
        return "DoctorScene";
    }
}
