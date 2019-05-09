package Controller;

import Database.Data;
import Model.AbstractUser;
import Model.DonorInfo;
import Model.PersonalInfo;
import Model.SearchInfo;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import users.GetDonorInfo;
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

    private ArrayList<AbstractUser> users;
    private ArrayList<PersonalInfo> personalInfos;
    private ArrayList<DonorInfo> donorInfos;

    private GetUserInfo userInfo = new GetUserInfo();
    private GetPersonalInfo personalInfo = new GetPersonalInfo();
    private GetDonorInfo donorInfo = new GetDonorInfo();

    public DoctorController() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        personalInfos = personalInfo.users();
        donorInfos = donorInfo.users();
    }
    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        super.initialize();
        final ObservableList<SearchInfo> data = FXCollections.observableArrayList();
        for (int x = 0;x<users.size();x++){
            data.add(new SearchInfo(users.get(x).getUserName(),personalInfos.get(x).getAddress(),donorInfos.get(x).getBloodTYpe(),donorInfos.get(x).getBloodPlasma(),donorInfos.get(x).getBoneMarrow()));
        }

        usernameColumn.setCellValueFactory(
                new PropertyValueFactory<SearchInfo,String>("userName")
        );
        addressColumn.setCellValueFactory(
                new PropertyValueFactory<SearchInfo,String>("address")
        );
        bloodTypeColumn.setCellValueFactory(
                new PropertyValueFactory<SearchInfo,String>("bloodTYpe")
        );
        plasmaColumn.setCellValueFactory(
                new PropertyValueFactory<SearchInfo,String>("bloodPlasma")
        );
        boneMarrowColumn.setCellValueFactory(
                new PropertyValueFactory<SearchInfo,String>("boneMarrow")
        );
        tableView.setItems(data);
    }
}