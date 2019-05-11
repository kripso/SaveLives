package Controller;

import Model.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import users.*;
import java.io.IOException;
import java.util.ArrayList;


public class DoctorController extends NurseController{

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
    public Group textFields;


    private ArrayList<AbstractUser> users;
    private ArrayList<PersonalInfo> personalInfos;
    private ArrayList<DonorInfo> donorInfos;

    private GetUserInfo userInfo = new GetUserInfo();
    private GetPersonalInfo personalInfo = new GetPersonalInfo();
    private GetDonorInfo donorInfo = new GetDonorInfo();

    public DoctorController() {

    }

    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        super.initialize();
        setUpTableView();

        textFields.setOnKeyPressed(event -> {
            try {
                setUpTableView();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

    }

    @Override
    public  void setUpTableView() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        personalInfos = personalInfo.users();
        donorInfos = donorInfo.users();

        final ObservableList<SearchInfo> data = FXCollections.observableArrayList();

        if(!findAddress.getText().equals("")){
            for (int x = 0; x<users.size();x++){
                if (!personalInfos.get(x).getAddress().equals(findAddress.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findBloodType.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!donorInfos.get(x).getBloodTYpe().equals(findBloodType.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findPlasmaRHD.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!donorInfos.get(x).getBloodPlasma().equals(findPlasmaRHD.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findBoneMarrowHLA.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!donorInfos.get(x).getBoneMarrow().equals(findBoneMarrowHLA.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findUserName.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!users.get(x).getUserName().equals(findUserName.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }

        if (users != null){
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
}