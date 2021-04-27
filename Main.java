import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws Exception {

        String personneltxt=args[0];
        String monitoringtxt=args[1];

        ArrayList<Personnel> personnelArrayList=FileOperations.readPersonnel(personneltxt);
        HashMap<String,Integer[]> monitoringMap=FileOperations.readMonitoring(monitoringtxt);


        for(Personnel person:personnelArrayList) {
            //writes outputs by using personnelArrayList
            person.calculateSalary(monitoringMap); }
        FileOperations.writeOutputs(personnelArrayList);
    }
}