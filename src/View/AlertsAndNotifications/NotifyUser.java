package View.AlertsAndNotifications;

import javafx.scene.control.Alert;

public class NotifyUser extends Alert {

    public NotifyUser(String message){
        super(AlertType.CONFIRMATION);
        this.setContentText("Notify user " + message + "?");
        this.showAndWait();
    }
}