package Alerts;

import View.AlertsAndNotifications.UserNotFoundAlert;
import View.AlertsAndNotifications.UsernameNotFoundAlert;
import javafx.scene.control.Alert;

public class MyAlerts extends Exception {
    private String username;

    public MyAlerts(String login) {
        username = login;
    }

    public void UsernameNotFoundAlert() {
        new UsernameNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
    public void UserNotFoundAlert() {
        new UserNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
}