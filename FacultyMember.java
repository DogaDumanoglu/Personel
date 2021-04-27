import java.util.HashMap;

public class FacultyMember extends Academician {

    private int addCourseFee;

    public FacultyMember(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname, registrationNumber, position, yearOfStart);
        setSsBenefits(getBaseSalary(),1.35);
    }

    /*calculateSalary method calculates faculty members salary.Faculty members gets total of
     base salary,severance payment,additional course fee and special service benefits every month.*/

    public void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap){
        findAdditionalCourseFee(weeklyHoursMap);
        setTotalSalary(addCourseFee+getBaseSalary()+findSeverancePay()+getSsBenefits());
    }

    /* findAdditionalCourseFee method calculates additional course fee
    when faculty members works more than 40 hours.Faculty members can
    gain 20 TL for each extra hour but if they work more than 8 extra
    hour they will not be paid additional money for this hours.*/

    public void findAdditionalCourseFee(HashMap<String,Integer[]> weeklyHoursMap){
        Integer[] weeklyHoursArray=weeklyHoursMap.get(getRegistrationNumber());
        for(Integer week:weeklyHoursArray){
            if((week>40)){
                if(week<48){
                    addCourseFee+=(week-40)*20;
                }
                else{
                    addCourseFee+=160;
                }
            }
        }
    }
}
