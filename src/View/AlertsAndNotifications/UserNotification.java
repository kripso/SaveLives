package View.AlertsAndNotifications;

import javafx.scene.control.Alert;

/**
 * alert pre upozornenie pouzivatela ze je potrebne jeho darcovstvo
 */
public class UserNotification extends Alert {

    public UserNotification(){
        super(AlertType.INFORMATION);
        this.setContentText("Your contribution is needed please go to the nearest Hospital");
        this.showAndWait();
    }
}