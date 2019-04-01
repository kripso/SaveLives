package Controller;

import View.LoginScreen;
import View.RegistrationScreen;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;

public class LoginController {

    public Label Registration;

    public LoginController(){

    }

    public void LoginPressed() throws Exception {
        Controller.SetScene(UserScreen.getscene());
    }

    public void Registration(MouseEvent mouseEvent) throws Exception {
        Controller.SetScene(RegistrationScreen.getscene());
    }

    public void MouseEntered(MouseEvent mouseEvent) {
        Registration.setTextFill(Color.BLUE);
    }

    public void MouseExited(MouseEvent mouseEvent) {
        Registration.setTextFill(Color.BLACK);
    }
}
