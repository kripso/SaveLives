package Controller;

import Database.Data;
import Model.User;
import View.RegistrationScreen;
import View.UserScreen;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import users.GetUserInfo;

import java.io.IOException;
import java.util.ArrayList;

public class LoginController {

    public Label Registration;
    public PasswordField Password;
    public TextField Username;

    ArrayList<User> users;
    GetUserInfo userInfo = new GetUserInfo();

    public LoginController() throws IOException, ClassNotFoundException {
        users = userInfo.users();
    }

    public void LoginPressed() throws Exception {
        User user = GetUser(Username.getText(), Password.getText());
        if (user != null) {
            new UserController();
            Data.getInstance().user = user;
            Controller.SetScene(UserScreen.getscene());
        }
    }

    public User GetUser(String userName, String password) {
        for (User user : users) {
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
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
