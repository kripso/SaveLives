package View.AlertsAndNotifications;

import javafx.scene.control.Alert;

/**
 * alert ktory upozornuje pouzivatela ze sa nenasiel uzivatel s takym prihlasovacim menom alebo heslom
 */
public class UsernameNotFoundAlert extends Alert {

    public UsernameNotFoundAlert(AlertType alertType, String message){
        super(alertType);
        this.setContentText("User " + message + " was not found.\nCheck username or password");
        this.showAndWait();
    }
}
