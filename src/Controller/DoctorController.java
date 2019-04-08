package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.PersonalInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import users.GetPersonalInfo;
import users.GetUserInfo;

import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class DoctorController extends NurseController {

    public TextField findUserName;
    public TextField findAddress;
    public TextField findBloodType;
    public TextField findPlasmaRHD;
    public TextField findBoneMarrowHLA;

    public TableView tableView;

    public TableColumn usernameColumn;
    public TableColumn addressColumn;
    public TableColumn bloodTypeColumn;
    public TableColumn plasmaColumn;
    public TableColumn boneMarrowColumn;

    ArrayList<PersonalInfo> personalInfos;
    GetPersonalInfo personalInfo = new GetPersonalInfo();

    ArrayList<String> names;
    ArrayList<String> addresses;
    ArrayList<String> bloodTypes;
    ArrayList<String> plasmas;
    ArrayList<String> bonemarrows;

    public DoctorController(){

    }
    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        super.initialize();

    }
}
