import java.util.HashMap;

public class Worker extends FullTimeEmployee {

    public Worker(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
        setTotalOfDailyPayments(105);
    }
    /*calculateSalary method calculates Workers salary.Workers gets total of daily payments,
   severance payment and over work salary every month.*/

    @Override
    public void calculateSalary(HashMap<String, Integer[]> weeklyHoursMap) {
        findOverWorkSalary(weeklyHoursMap, 10, 11);
        setTotalSalary(getOverWorkSalary() + findSeverancePay() + getTotalOfDailyPayments());
    }
}

