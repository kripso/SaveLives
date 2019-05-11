package users;

import Model.AbstractUser;
import Model.User;

import java.util.ArrayList;
import java.util.Random;

public class UsersGenerator {

    public static String[] username = {
           "Tamara",
           "Noe",
           "Clinton",
           "Stephany",
           "Shelby",
           "Mark",
           "Ana",
           "Ari",
           "Carlee",
           "Brent",
           "Aedan",
           "Dawson",
           "Alexzander",
           "Norah",
           "Maddox",
           "Kolten",
           "Marcus",
           "Kamron",
           "Meghan",
           "Mariela",
           "Mathias",
           "Nathalia",
           "Jaqueline",
           "Pablo",
           "Hope",
           "Mireya",
           "Jaylin",
           "Marco",
           "Kylie",
           "Ruth",
           "Selena",
           "Chelsea",
           "Kali",
           "Leilani",
           "Dominik",
           "Layne",
           "Hayden",
           "Madelynn",
           "Matthias",
           "Ariana",
           "Jorden",
           "Marcelo",
           "Julie",
           "Damari",
           "Abel",
           "Mattie",
           "Gia",
           "Albert",
           "Gaven",
           "Nia"
    };
    String password = "password";
    String[] ocupation = {"User","Doctor","Nurse"};

    public ArrayList<AbstractUser> generate() {
        ArrayList<AbstractUser> abstractUsers = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Random random  = new Random();
            AbstractUser abstractUser = new User(username[i], password, ocupation[random.nextInt(3)],random.nextBoolean(),false);
            abstractUsers.add(abstractUser);
        }
        return abstractUsers;
    }
}
