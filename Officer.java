import java.util.HashMap;

public class Officer extends Personnel{

    private int baseSalary;
    private double ssBenefits;
    private int overWorkSalary;

    public Officer(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
        baseSalary = 2600;
        ssBenefits=0.65*baseSalary;
    }

    public double getSsBenefits() {
        return ssBenefits;
    }

    public void setSsBenefits(double ssBenefits) {
        this.ssBenefits = ssBenefits;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    /*calculateSalary method calculates officers salary.Officers gets total of
      base salary,severance payment,over work salary and special service benefits every month.*/

    @Override
    public void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap){
        findOverWorkSalary(weeklyHoursMap);
        setTotalSalary(baseSalary+ssBenefits+findSeverancePay()+overWorkSalary); }

    /* findOverWorkSalary method calculates over work salary when
     officers works more than 40 hours.Officers can gain 20 TL for
     each extra hour but if they work more than 10 hour
     they will not be paid additional money for this hours.*/

    public void findOverWorkSalary(HashMap<String,Integer[]> weeklyHoursMap) {
        Integer[] weeklyHoursArray = weeklyHoursMap.get(getRegistrationNumber());
        for (Integer week : weeklyHoursArray) {
            if ((week > 40)) {
                if(week<50){
                overWorkSalary += (week - 40) * 20;}
                else{
                    overWorkSalary+=20*10;
                }
            }
        }
    }
}

