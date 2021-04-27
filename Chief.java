import java.util.HashMap;

public class Chief extends FullTimeEmployee {

    public Chief(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
        setTotalOfDailyPayments(125);
    }

    /*calculateSalary method calculates Chiefs salary.Chiefs gets total of daily payments,
    severance payment and over work salary every month.*/

    @Override
    public void calculateSalary(HashMap<String, Integer[]> weeklyHoursMap) {
        findOverWorkSalary(weeklyHoursMap, 8, 15);
        setTotalSalary(getOverWorkSalary() + findSeverancePay() + getTotalOfDailyPayments());
    }
}
