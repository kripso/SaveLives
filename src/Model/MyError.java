package Model;

import View.UserNotFoundAlert;
import View.UsernameNotFoundAlert;
import javafx.scene.control.Alert;

public class MyError extends Exception {
    String username;

    public MyError(String login) {
        username = login;
    }


    public void UsernameNotFoundAlert() {
        new UsernameNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
    public void UserNotFoundAlert() {
        new UserNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
}