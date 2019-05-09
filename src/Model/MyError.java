package Model;

import View.UserNotFoundAlert;
import View.UsernameNotFoundAlert;
import javafx.scene.control.Alert;

public class MyError extends Exception {
    String username;

    public MyError(String login) {
        username = login;
    }
    public void UsernameNotFoundAlert(String text) {
        new UsernameNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
    public void UserNotFoundAlert(String text) {
        new UserNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
}