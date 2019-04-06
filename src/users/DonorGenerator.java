package users;

import Model.AbstractUser;
import Model.Donor;
import Model.User;

import java.util.ArrayList;

public class DonorGenerator {

    String[] username = {"Eveline", "Eugenio", "Clarisa", "Mary", "Hyman", "May", "Felisha", "Oda", "Magaly", "Hyon"};

    public ArrayList<Donor> generate() {
        ArrayList<Donor> donors = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Donor donor = new Donor(username[i],"","","","","");
            donors.add(donor);
        }
        return donors;
    }
}
