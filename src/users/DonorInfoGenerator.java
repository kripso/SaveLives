package users;

import Model.DonorInfo;
import Model.PersonalInfo;

import java.util.ArrayList;

public class DonorInfoGenerator {

    public ArrayList<DonorInfo> generate(String[] username) {
        ArrayList<DonorInfo> donorInfos = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            DonorInfo donorInfo = new DonorInfo(username[i],"","","");
            donorInfos.add(donorInfo);
        }
        return donorInfos;
    }
}
