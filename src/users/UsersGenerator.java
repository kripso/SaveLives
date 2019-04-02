package users;

import Model.User;

import java.util.ArrayList;

public class UsersGenerator {

    String[] username = {"Eveline", "Eugenio", "Clarisa", "Mary", "Hyman", "May", "Felisha", "Oda", "Magaly", "Hyon"};
    String password = "password";
    //String[] password = {"Hendren", "Petillo","Wait","Samsel","Maland","Wierenga","Giesen","Shorty","Basco","Turek"};
    String[] ocupation = {"User","User","User","User","Doctor","Nurse","Doctor","Nurse","Doctor","Hospital"};

    public ArrayList<User> generate() {
        ArrayList<User> users = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User(username[i], password,ocupation[i],i%2==0);
            users.add(user);
        }
        return users;
    }
}
