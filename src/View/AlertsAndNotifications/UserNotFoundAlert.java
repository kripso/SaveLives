package View.AlertsAndNotifications;

import javafx.scene.control.Alert;

/**
 * alert ktory sa zobrazi ked sa nenajde patričný pouzivatel
 */
public class UserNotFoundAlert extends Alert {

    public UserNotFoundAlert(AlertType alertType, String message){
        super(alertType);
        this.setContentText("User " + message + " does not exist");
        this.showAndWait();
    }
}