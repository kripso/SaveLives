package Controller;

import Model.*;
import View.NotifyUser;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import users.*;
import java.io.IOException;
import java.util.ArrayList;
/**
 * <h1>DoctorController</h1>
 * Controller ma za ulohu nastavovat patricne View podla toho kto sa prihlasi
 * @author  Roland Rajcsanyi
 */
public class DoctorController extends NurseController{
    /**
     *inicializovanie textfieldov ktore sa nachadzaju nad tabulkou
     *inicializovanie a osobnych a darcovskych udajov o vsetkych pouzivateloch
     */
    public TextField findUserName;
    public TextField findAddress;
    public TextField findBloodType;
    public TextField findPlasmaRHD;
    public TextField findBoneMarrowHLA;

    public TableView<SearchInfo> tableView;

    public TableColumn<SearchInfo, String> usernameColumn;
    public TableColumn<SearchInfo, String> addressColumn;
    public TableColumn<SearchInfo, String> bloodTypeColumn;
    public TableColumn<SearchInfo, String> plasmaColumn;
    public TableColumn<SearchInfo, String> boneMarrowColumn;
    public Group textFields;


    private ArrayList<AbstractUser> users;
    private ArrayList<PersonalInfo> personalInfos;
    private ArrayList<DonorInfo> donorInfos;

    private GetUserInfo userInfo = new GetUserInfo();
    private GetPersonalInfo personalInfo = new GetPersonalInfo();
    private GetDonorInfo donorInfo = new GetDonorInfo();

    public DoctorController() throws IOException, ClassNotFoundException {
        super();
    }
    /**
     * fukcia na hladanie substring ale upravena na to aby ignorovala velke a male pismena
     */
    private static boolean containsIgnoreCase(String str, String subString) {
        return str.toLowerCase().contains(subString.toLowerCase());
    }
    /**
     * pridana eventhandler ktory zistuje ktora cast tabulky bola kliknuta a nasledne vyskoceny alert pre upozornenie uzivatela na ktoreho sa kliklo
     * dalej textfields su vsetky textfieldy pouzite na vyhladavanie
     */
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
        tableView.setOnMouseClicked(event -> {
            SearchInfo searchInfo = tableView.getSelectionModel().getSelectedItem();
            NotifyUser notifyUser = new NotifyUser(searchInfo.getUserName());
            if (notifyUser.getResult().getText().equals("OK")){
                for (AbstractUser abstractUser : users) {
                    if (abstractUser.getUserName().equals(searchInfo.getUserName())) {
                        try {
                            SaveUsers.updateUserInfo(abstractUser, true);
                        } catch (ClassNotFoundException | IOException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        });

    }
    /**
     * funkcia ktora nastavuje tabulku
     */
    @Override
    public  void setUpTableView() throws IOException, ClassNotFoundException {
        users = userInfo.users();
        personalInfos = personalInfo.users();
        donorInfos = donorInfo.users();

        final ObservableList<SearchInfo> data = FXCollections.observableArrayList();
        /**
         * najskor program prehlada vsetkych pouzivatelov a vymaze z dat tych ktory nechcu byt darcovia
         */
        for (int x = 0; x<users.size();x++){
            if (!users.get(x).getDonor()){
                personalInfos.remove(x);
                users.remove(x);
                donorInfos.remove(x);
                x--;
            }
        }
        /**
         * nasledovne podmienky sluzia na triedenie tabulky a mazanie tych darcov ktory nesplnaju podmienky zadane doktorov v textfieldoch
         * findUserName
         * findAddress
         * findBloodType
         * findPlasmaRHD
         * findBoneMarrowHLA
         */
        if(!findAddress.getText().equals("")){
            for (int x = 0; x<users.size();x++){
                if (!containsIgnoreCase(personalInfos.get(x).getAddress(),findAddress.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findBloodType.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!containsIgnoreCase(donorInfos.get(x).getBloodTYpe(),findBloodType.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findPlasmaRHD.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!containsIgnoreCase(donorInfos.get(x).getBloodPlasma(),findPlasmaRHD.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findBoneMarrowHLA.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!containsIgnoreCase(donorInfos.get(x).getBoneMarrow(),findBoneMarrowHLA.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        if(!findUserName.getText().equals("")){
            for (int x = 0;x<users.size();x++){
                if (!containsIgnoreCase(users.get(x).getUserName(),findUserName.getText())){
                    personalInfos.remove(x);
                    users.remove(x);
                    donorInfos.remove(x);
                    x--;
                }
            }
        }
        /**
         * vyplnenie tabulky udajmi ktore presli triedenim
         */
        if (users != null){
            for (int x = 0;x<users.size();x++){
                data.add(new SearchInfo(users.get(x).getUserName(),personalInfos.get(x).getAddress(),donorInfos.get(x).getBloodTYpe(),donorInfos.get(x).getBloodPlasma(),donorInfos.get(x).getBoneMarrow()));
            }

            usernameColumn.setCellValueFactory(
                    new PropertyValueFactory<>("userName")
            );
            addressColumn.setCellValueFactory(
                    new PropertyValueFactory<>("address")
            );
            bloodTypeColumn.setCellValueFactory(
                    new PropertyValueFactory<>("bloodTYpe")
            );
            plasmaColumn.setCellValueFactory(
                    new PropertyValueFactory<>("bloodPlasma")
            );
            boneMarrowColumn.setCellValueFactory(
                    new PropertyValueFactory<>("boneMarrow")
            );
            tableView.setItems(data);
        }
    }

}