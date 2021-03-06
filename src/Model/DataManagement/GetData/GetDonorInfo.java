package Model.DataManagement.GetData;

import Model.DonorInfo;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
/**
 * treda vyuzita na nacitavanie udajov o vsetkych darcoch
 */
public class GetDonorInfo {

    public ArrayList<DonorInfo> users() throws IOException, ClassNotFoundException {
        ObjectInputStream in = new ObjectInputStream(new FileInputStream("DonorInfo.out"));
        ArrayList<DonorInfo> donorInfos = (ArrayList<DonorInfo>) in.readObject();
        in.close();
        return donorInfos;
    }
}
