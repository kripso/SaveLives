package Controller;

import Database.Data;
import View.UserScreen;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;
import users.SaveUsers;

import java.io.IOException;

public class NurseController extends UserController {


    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorCheckBox;
    public Tab DonorTab;
    public javafx.scene.control.TabPane TabPane;
    public Tab UserTab;

    public NurseController(){
        System.out.println("ahojNurse");
    }

}
