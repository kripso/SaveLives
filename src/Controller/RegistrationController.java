package Controller;

import View.LoginScreen;
import View.UserScreen;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;

public class RegistrationController {


    public RegistrationController(){

    }

    public void RegisterPressed() throws Exception {
        Controller.SetScene(UserScreen.getscene());
    }

    public void Registration(MouseEvent mouseEvent) {
        System.out.println("ahoj");
    }

}
