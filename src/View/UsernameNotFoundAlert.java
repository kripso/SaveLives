package View;

import javafx.scene.control.Alert;

public class UsernameNotFoundAlert extends Alert {

    public UsernameNotFoundAlert(AlertType alertType, String message){
        super(alertType);
        this.setContentText("User" + message + "was not found.\nCheck username or password");
        this.showAndWait();
    }
}
