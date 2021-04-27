import java.util.HashMap;

public class ResearchAssistant extends Academician {
    public ResearchAssistant(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
        setSsBenefits(getBaseSalary(),1.05);

    }
    /*calculateSalary method calculates research assistants salary.Research assistants gets total of
     base salary,severance payment and special service benefits every month.*/
    @Override
    public void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap){
        this.setTotalSalary(getBaseSalary()+findSeverancePay()+getSsBenefits()); }
}