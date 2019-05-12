package Model.DataManagement.GenetareData;

import Model.DonorInfo;

import java.util.ArrayList;
import java.util.Random;

/**
 * Generator na udaja o darcoch
 */
public class DonorInfoGenerator {
    String[] bloodType = {"A+","A-","B+","B-","0+","0-","AB+","AB-"};
    String[] plasma = {"A AB","A AB","B AB","B AB","0","0","AB","AB"};
    String[] boneMarrow = {"a b c c d","c a s s b","k s d d f","a a a d d","g g f d d","t t t r e"};
    public ArrayList<DonorInfo> generate(String[] username) {

        ArrayList<DonorInfo> donorInfos = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Random random = new Random();
            int x = random.nextInt(8);
            DonorInfo donorInfo = new DonorInfo(username[i],bloodType[x],plasma[x],boneMarrow[random.nextInt(6)]);
            donorInfos.add(donorInfo);
        }
        return donorInfos;
    }
}
