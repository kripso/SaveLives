package View.AlertsAndNotifications;

import javafx.scene.control.Alert;

/**
 * alert ktory sa spýta doktora ci ma program upozornit patričneho pouzivatela
 */
public class NotifyUser extends Alert {

    public NotifyUser(String message){
        super(AlertType.CONFIRMATION);
        this.setContentText("Notify user " + message + "?");
        this.showAndWait();
    }
}