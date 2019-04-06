package users;

import Model.AbstractUser;
import Model.User;

import java.util.ArrayList;

public class UsersGenerator {

    String[] username = {"Eveline", "Eugenio", "Clarisa", "Mary", "Hyman", "May", "Felisha", "Oda", "Magaly", "Hyon"};
    String password = "password";
    //String[] password = {"Hendren", "Petillo","Wait","Samsel","Maland","Wierenga","Giesen","Shorty","Basco","Turek"};
    String[] ocupation = {"User","User","User","User","Doctor","User","Doctor","Nurse","Doctor","Hospital"};

    public ArrayList<AbstractUser> generate() {
        ArrayList<AbstractUser> abstractUsers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            AbstractUser abstractUser = new User(username[i], password,ocupation[i],true);
            abstractUsers.add(abstractUser);
        }
        return abstractUsers;
    }
}
