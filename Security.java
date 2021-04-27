import java.util.HashMap;

public class Security extends Personnel{
    private int hourOfWorkPayment;
    private int totalTransMoney;
    private int totalFoodMoney;

    public Security(String nameSurname, String registrationNumber, String position,int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
    }
    /*calculateSalary method calculates securities salary.Securities gets total of payment
    for each hour they work,severance payment and money for transportation and food every month.*/

    @Override
    public void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap){
        findHourOfWorkPayment(weeklyHoursMap);
        setTotalSalary(hourOfWorkPayment+totalTransMoney+totalFoodMoney+findSeverancePay());}

        /*  findHourOfWorkPayment method calculates total payment for securities.
        Securities gain 10 TL for each hour that they work but they have to work
        at least 30 hours in a week.If they work less than 30 hour they can not
         gain any money for working hours.Also if they work more than 54 hours
         they will not be paid additional money for this hours.(because they have
         to work min 5 hour and max 9 hour in a day they have to work 6 day in a week)*/

    public void findHourOfWorkPayment(HashMap<String,Integer[]> weeklyHoursMap){
        int transMoney=5;//every day they get money for transportation.
        int foodMoney=10;//every day they get money for food.
        Integer[] weeklyHoursArray = weeklyHoursMap.get(getRegistrationNumber());
        for (Integer week : weeklyHoursArray) {
            if ((week >= 30)) {
                totalTransMoney+=transMoney*6;
                totalFoodMoney+=foodMoney*6;
                if(week<54){
                    hourOfWorkPayment += week*10;
                }
                else {
                hourOfWorkPayment += 540;}
            }
        }
    }
}
