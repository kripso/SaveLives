package Model.DataManagement.GenetareData;

import Model.PersonalInfo;

import java.util.ArrayList;
import java.util.Random;

public class PersonalInfoGenerator {
    private String[] surname = {"Jeli", "Kori", "Holi", "Nora", "Hyme", "Lay", "kor", "Ose", "Sko", "Hyon"};
    private  String[] address = {
           "Jarembina",
           "Štúrovo",
           "Poločáre",
           "Svätý Jur",
           "Hrušov",
           "Bobrovček",
           "Gest",
           "Solnička",
           "Malé Stankovce",
           "Dvor Stankovce"};

    public ArrayList<PersonalInfo> generate(String[] username) {
        ArrayList<PersonalInfo> personalInfos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            PersonalInfo personalInfo = new PersonalInfo(username[i],username[i],surname[random.nextInt(10)],address[random.nextInt(10)],username[random.nextInt(10)] + "@email.com",String.valueOf(random.nextInt(1000000)));
            personalInfos.add(personalInfo);
        }
        return personalInfos;
    }
}
