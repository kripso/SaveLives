package Controller;

import View.*;
import javafx.stage.Stage;
import users.*;

import java.io.IOException;

/**
 * <h1>Controller</h1>
 * Controller ma za ulohu nastavovat patricne View podla toho kto sa prihlasi
 * @author  Roland Rajcsanyi
 */

public class Controller {
    private static Stage PrimaryStage = new Stage();
    /**
     * Kedze samotny controller sa initializuje iba raz tak pri jeho volani vytvaram zakladnych pouzivatelov
     * a ukladam ich hodnoty do .out zloziek
     */
    public Controller() throws IOException {
        UsersGenerator usersGenerator = new UsersGenerator();
        PersonalInfoGenerator personalInfoGenerator = new PersonalInfoGenerator();
        DonorInfoGenerator donorInfoGenerator = new DonorInfoGenerator();
        SaveDonorInfo.donorInfo(donorInfoGenerator.generate(UsersGenerator.username));
        SaveUsers.users(usersGenerator.generate());
        SavePersonalInfo.personalInfo(personalInfoGenerator.generate(UsersGenerator.username));
    }
    /**
     * Ked metoda SetScene prima nejaky parameter typu string tak sa spusti tato verzia SetScene
     * kde switch hlada ktoru scenu ma probram zapnut
     * @param SetActiveScene String parameter ktory volaju controlery LoginController a Registration Controller
     * program potom nastavy PrimaryStagy vo view.
     */
    static void SetScene(String SetActiveScene) throws Exception {
        switch (SetActiveScene) {
            case "UserScene":
                new UserScreen(PrimaryStage);
                break;
            case "NurseScene":
                new NurseScreen(PrimaryStage);
                break;
            case "DoctorScene":
                new DoctorScreen(PrimaryStage);
                break;
            case "LoginScene":
                new LoginScreen(PrimaryStage);
                break;
            case "RegistrationScene":
                new RegistrationScreen(PrimaryStage);
                break;
        }
    }
    /**
     * Metoda ktora sa spusti na zaciatku programu
     * ked SetScene neprima ziaden parameter
     */
    public static void SetScene() throws Exception {
        new LoginScreen(PrimaryStage);
    }
}
