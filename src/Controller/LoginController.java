package Controller;

import View.LoginScreen;
import javafx.event.ActionEvent;

public class LoginController {

    public void loginPressed() throws Exception {
        Controller.SetScene(LoginScreen.getscene());
    }
}
