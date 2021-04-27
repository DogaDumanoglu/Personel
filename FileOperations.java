import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/*ReadFromFile function reads the lines from the file. Returns the list.
 *if a problem is encountered throws IOException.*/

public class FileOperations {
    public static List<String> readFile(String path) {
        try {
            return Files.readAllLines(Paths.get(path));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    /*writeOutput method creates different file for every personnel and writes required attributes to the files*/
    public static void writeOutputs(ArrayList<Personnel> personnelArrayList) throws IOException {
        for (Personnel p : personnelArrayList) {
            String fileName =personnelArrayList.get(personnelArrayList.indexOf(p)).getRegistrationNumber()+".txt";
            Files.write(Paths.get(fileName), p.toString().getBytes());}}

    /*readMonitoring method reads monitoring.txt file which keeps weekly working hours.This function put weekly
     hours in arrays then puts this arrays in the hashmaps according to the registration number which it belongs*/

    public static HashMap<String,Integer[]> readMonitoring(String path) {

        List<String> lines = readFile(path);
        HashMap<String,Integer[]> weeklyHoursMap = new HashMap<>();

        for (String line : Objects.requireNonNull(lines)) {
            String[] monitoringInfosArray = line.split("\t");
            String registration = monitoringInfosArray[0];
            int week1 = Integer.parseInt(monitoringInfosArray[1]);
            int week2 = Integer.parseInt(monitoringInfosArray[2]);
            int week3 = Integer.parseInt(monitoringInfosArray[3]);
            int week4 = Integer.parseInt(monitoringInfosArray[4]);
            Integer[] weeklyHoursArray={week1,week2,week3,week4};

            weeklyHoursMap.put(registration, weeklyHoursArray);
        }
        return weeklyHoursMap;
    }
    /*personnelGet method finds personnel position then creates new personnel and returns it */

    public static Personnel personnelGet(HashMap<String, Personnel> personnelMap, String nameSurname, String registrationNumber, String position, int yearOfStart) {

        if (!personnelMap.containsKey(registrationNumber)) {

            switch (registrationNumber.substring(0, 1)) {
                case "F":personnelMap.put(registrationNumber, new FacultyMember(nameSurname, registrationNumber, position, yearOfStart));break;
                case "R":personnelMap.put(registrationNumber, new ResearchAssistant(nameSurname, registrationNumber, position, yearOfStart));break;
                case "O":personnelMap.put(registrationNumber, new Officer(nameSurname, registrationNumber, position, yearOfStart));break;
                case "P":personnelMap.put(registrationNumber, new PartTimeEmployee(nameSurname, registrationNumber, position, yearOfStart));break;
                case "C":personnelMap.put(registrationNumber, new Chief(nameSurname, registrationNumber, position, yearOfStart));break;
                case "W":personnelMap.put(registrationNumber, new Worker(nameSurname, registrationNumber, position, yearOfStart));break;
                case "S":personnelMap.put(registrationNumber, new Security(nameSurname, registrationNumber, position, yearOfStart));break;
                default:break;
            }
        }
        return personnelMap.get(registrationNumber); }

    /*readPersonnel method reads personnel.txt file which keeps
    all personnel and their attributes.Then creates every personnel
    by calling getPersonnel method and puts them in an arraylist.*/

    public static ArrayList<Personnel> readPersonnel(String path){

        ArrayList<Personnel> personnelArrayList = new ArrayList<>();
        HashMap<String, HashMap<String, Personnel>> personnelMap = new HashMap<>();

        //this hashmaps for getPersonnel method to be able to returns relevant hashmaps
        personnelMap.put("F", new HashMap<>());
        personnelMap.put("R", new HashMap<>());
        personnelMap.put("O", new HashMap<>());
        personnelMap.put("P", new HashMap<>());
        personnelMap.put("C", new HashMap<>());
        personnelMap.put("W", new HashMap<>());
        personnelMap.put("S", new HashMap<>());

        List<String> lines = readFile(path);

        for (String line : Objects.requireNonNull(lines)) {

            String[] personnelInfos = line.split("\t");
            String nameSurname = personnelInfos[0];
            String registrationNumber = personnelInfos[1];
            String position = personnelInfos[2];
            int yearOfStart = Integer.parseInt(personnelInfos[3]);

            Personnel personnel = personnelGet(personnelMap.get(registrationNumber.substring(0, 1)), nameSurname, registrationNumber, position, yearOfStart);
            if(personnel!=null)
            personnelArrayList.add(personnel);

        }
        return personnelArrayList;
    }
}