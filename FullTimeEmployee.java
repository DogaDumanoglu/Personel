import java.util.HashMap;

public abstract class FullTimeEmployee extends Employee {
    //This class is the template for chief class and worker class.
    private int overWorkSalary;
    private int totalOfDailyPayments;
    public FullTimeEmployee(String nameSurname, String registrationNumber, String position,int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
    }

    public int getOverWorkSalary() { return overWorkSalary; }

    public void setOverWorkSalary(int overWorkSalary) { this.overWorkSalary = overWorkSalary; }

    public int getTotalOfDailyPayments() { return totalOfDailyPayments; }

    /*setTotalOfDailyPayments method calculates total of daily payments.
    Full time employees gets particular payment every day they works.
    They can work only weekdays(5day) so they work total 20 day in a month*/

    public void setTotalOfDailyPayments(int paymentPerDay) {
        this.totalOfDailyPayments=paymentPerDay*5*4;}

    /* findOverWorkSalary method calculates over work salary
    when full time employee works more than 40 hours.Full time
    employee can gain specific payment for each extra hour but
    if they work more than their hour limit they will not be
    paid additional money for this hours.*/

    public void findOverWorkSalary(HashMap<String,Integer[]> weeklyHoursMap,int hourLimit,int paymentForEachHour) {
        Integer[] weeklyHoursArray = weeklyHoursMap.get(getRegistrationNumber());
        for (Integer week : weeklyHoursArray) {
            if ((week >= 40)) {
                if((week<40+hourLimit)){
                    setOverWorkSalary(getOverWorkSalary()+(week - 40) * paymentForEachHour);
                }
                else{
                    setOverWorkSalary(getOverWorkSalary()+(paymentForEachHour*hourLimit)); }
            }
        }

    }
}
