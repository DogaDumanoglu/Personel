import java.util.HashMap;

public class PartTimeEmployee extends Employee {
    private int hourOfWorkSalary;
    public PartTimeEmployee(String nameSurname, String registrationNumber, String position,int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
    }

    /*calculateSalary method calculates part time employees.Part time employees gets total of ,hourly payment and
    severance payment every month.*/

    @Override
    public void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap){
        findHourOfWorkPayment(weeklyHoursMap);
        setTotalSalary(hourOfWorkSalary+findSeverancePay());}

    /*  findHourOfWorkPayment method calculates total payment for part time
        employee.Part time employee gains 18 TL for each hour that they work but they
        have to work at least 9 hours.If they work less than 9 hour they can
        not gain any money for working hours.Also if they work more than 20 hours
        they will not be paid additional money for this hours.*/

    public void findHourOfWorkPayment(HashMap<String,Integer[]> weeklyHoursMap) {
        Integer[] weeklyHoursArray = weeklyHoursMap.get(getRegistrationNumber());
        for (Integer week : weeklyHoursArray) {
            if (week > 9){
                if(week<20){
                hourOfWorkSalary += (week) * 18;}
            else{
                hourOfWorkSalary+=18*20; }
            }
        }
    }
}
