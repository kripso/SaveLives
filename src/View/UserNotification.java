package View;

import javafx.scene.control.Alert;

public class UserNotification extends Alert {

    public UserNotification(){
        super(AlertType.INFORMATION);
        this.setContentText("Your contribution is needed please go to the nearest Hospital");
        this.showAndWait();
    }
}