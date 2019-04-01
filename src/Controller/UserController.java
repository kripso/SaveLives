package Controller;

import View.LoginScreen;
import View.UserScreen;
import javafx.event.ActionEvent;

public class UserController {

    public void LogoutPressed() throws Exception {
        Controller.SetScene(LoginScreen.getscene());
    }
}
