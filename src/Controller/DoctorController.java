package Controller;

import javafx.scene.control.CheckBox;
import javafx.scene.control.Tab;
import javafx.scene.control.TextField;

public class DoctorController extends NurseController {


    public TextField UsernameTxtF;
    public TextField PasswordTxtF;
    public TextField OccupationTxtF;
    public CheckBox DonorCheckBox;
    public Tab DonorTab;
    public javafx.scene.control.TabPane TabPane;
    public Tab UserTab;

    public DoctorController(){
        System.out.println("ahojDoctor");
    }

}
