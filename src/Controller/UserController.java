package Controller;

import Model.Database.Data;
import Model.PersonalInfo;
import Model.User;
import View.AlertsAndNotifications.UserNotification;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import Model.DataManagement.SaveData.SavePersonalInfo;
import Model.DataManagement.SaveData.SaveUsers;
import java.io.IOException;
/**
 * <h1>UserController</h1>
 * UserController je denen z hlavnych kontrollerov od ktoreho dedia NurseController a DoctorController
 * tento controler inicializuje vsetky veci pre vsetky typy pouzivatelov
 * @author Roland Rajcsanyi
 */
public class UserController {
    /**
     * inicializovanie textfieldov a zakladnych prvkov z UI
     * a inicializovanie Usera, a jeho osobnych udajov
     */
    public javafx.scene.control.TabPane tabPane;
    public Tab personalInfoTab;
    public Tab userTab;

    public TextField usernameTxtF;
    public TextField passwordTxtF;
    public TextField occupationTxtF;
    public CheckBox donorCheckBox;

    public TextField address;
    public TextField email;
    public TextField phoneNumber;
    public TextField name;
    public TextField surname;

    public User user = (User) Data.getInstance().abstractUser;
    public PersonalInfo personalInfo = Data.getInstance().personalInfo;
    public Button addInformationButton;

    /**
     * na zaciatku programu sa zistuje ci ma uzivatel pripominku od doctora
     * ked ano vyskoci allert ze je potrebne darovanie
     */
    public UserController() throws IOException, ClassNotFoundException {
        if(user.isContribution()){
            UserNotification userNotification = new UserNotification();
            if(userNotification.getResult().getText().equals("OK")){
                SaveUsers.updateUserInfo(user, false);
            }
        }
    }

    /**
     * initialize inicializuje textfieldy s osobnymi informaciami ak su uz v systeme nejake ulozene
     * takisto sa pozera ci chce byt uzivatel aj darca a podla toho skryje alebo necha personalInfoTab zobrazeny
     * dalej je addInformationButton ktory caka na akciu od pouzivatela a nasledne zavola funkciu addInformationPressed
     */
    @FXML
    public void initialize() throws IOException, ClassNotFoundException {
        usernameTxtF.setText(user.getUserName());
        passwordTxtF.setText(user.getPassword());
        occupationTxtF.setText(user.getOccupation());
        donorCheckBox.setSelected(user.getDonor());

        name.setText(personalInfo.getName());
        surname.setText(personalInfo.getSurname());
        address.setText(personalInfo.getAddress());
        email.setText(personalInfo.getEmail());
        phoneNumber.setText(personalInfo.getPhoneNum());

        userTab.setClosable(false);

        if (!donorCheckBox.isSelected()){
            tabPane.getTabs().remove(personalInfoTab);
        }

       addInformationButton.setOnAction(event -> {
           try {
               addInformationPressed();
           } catch (IOException | ClassNotFoundException e) {
               e.printStackTrace();
           }
       });
    }

    /**
     * ohlasenie uzivatela a nastavenie dat na null
     */
    public void LogoutPressed() throws Exception {
        Data.getInstance().abstractUser = null;
        Data.getInstance().personalInfo = null;
        Data.getInstance().donorInfo    = null;
        Controller.SetScene();
    }

    /**
     * donor check box nastvuje ci uzivatel chce alebo nechce byt darcom
     * zaroven uklada tieto informacie do dat
     */
    public void DonorCheckBoxChecked(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        if (!donorCheckBox.isSelected()){
            Data.getInstance().abstractUser.setDonor(false);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser, usernameTxtF.getText());
            tabPane.getTabs().remove(personalInfoTab);
        }else {
            Data.getInstance().abstractUser.setDonor(true);
            SaveUsers.updateUserInfo(Data.getInstance().abstractUser, usernameTxtF.getText());
            tabPane.getTabs().add(1, personalInfoTab);
        }
        user.setDonor(Data.getInstance().abstractUser.getDonor());
    }

    /**
     *  Zmenenie prihlasovacieho mena po stlaceni enter
     */
    public void usernameOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
        SavePersonalInfo.updatePersonalInfo(personalInfo, usernameTxtF.getText());
        user.setUserName(usernameTxtF.getText());
        personalInfo.setUserName(usernameTxtF.getText());
        Data.getInstance().abstractUser.setUserName(usernameTxtF.getText());
        Data.getInstance().personalInfo.setUserName(usernameTxtF.getText());
    }
    /**
     * zmena hesla po stlaceni enter
     */
    public void passwordOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setPassword(passwordTxtF.getText());
        Data.getInstance().abstractUser.setPassword(passwordTxtF.getText());
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
    }
    /**
     * zmena zamestnanie po stlaceni enter
     */
    public void occupationOnEnter(ActionEvent actionEvent) throws IOException, ClassNotFoundException {
        user.setOccupation(occupationTxtF.getText());
        Data.getInstance().abstractUser.setOccupation(occupationTxtF.getText());
        SaveUsers.updateUserInfo(user, usernameTxtF.getText());
    }
    /**
     * funkcia ktora nastavuje osobne informacie o userovy podla udajov z textfieldov
     */
    public void addInformationPressed() throws IOException, ClassNotFoundException {
        PersonalInfo personalInfo = new PersonalInfo(Data.getInstance().abstractUser.getUserName(), name.getText(), surname.getText(), address.getText(), email.getText(), phoneNumber.getText());
        SavePersonalInfo.personalInfo(personalInfo);
        Data.getInstance().personalInfo = personalInfo;
    }
}
