package users;

import Model.PersonalInfo;

import java.util.ArrayList;

public class PersonalInfoGenerator {

    public ArrayList<PersonalInfo> generate(String[] username) {
        ArrayList<PersonalInfo> personalInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            PersonalInfo personalInfo = new PersonalInfo(username[i],"","","","","");
            personalInfos.add(personalInfo);
        }
        return personalInfos;
    }
}
