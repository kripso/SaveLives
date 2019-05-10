package Model;

import View.UserNotFoundAlert;
import View.UsernameNotFoundAlert;
import javafx.scene.control.Alert;

public class MyError extends Exception {
    String username;
    String missingInfo;

    public MyError(String login) {
        username = login;
    }
    public MyError(int index) {
        if (index == 0){this.missingInfo = "Missing Email";}
        if (index == 1){this.missingInfo = "Missing Address";}
        if (index == 2){this.missingInfo = "Missing Phone number";}
    }

    public void UsernameNotFoundAlert() {
        new UsernameNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
    public void UserNotFoundAlert() {
        new UserNotFoundAlert(Alert.AlertType.INFORMATION,username);
    }
    public void MissingInfoAlert() {
        new UserNotFoundAlert(Alert.AlertType.INFORMATION,missingInfo);
    }
}