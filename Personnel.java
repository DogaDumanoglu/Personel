import java.util.HashMap;
import java.util.Locale;

public abstract class Personnel {
    //This class is the template for academician class,employee class,security class,officer class.

    private String nameSurname;
    private String registrationNumber;
    private String position;
    private int yearOfStart;
    private double totalSalary;

    public Personnel(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        this.nameSurname = nameSurname;
        this.registrationNumber = registrationNumber;
        this.position = position;
        this.yearOfStart = yearOfStart;
    }

    public String getNameSurname() {
        return nameSurname;
    }

    public void setNameSurname(String nameSurname) {
        this.nameSurname = nameSurname;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public int getYearOfStart() { return yearOfStart; }

    public void setYearOfStart(int yearOfStart) {
        this.yearOfStart = yearOfStart;
    }

    public Double getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(double totalSalary) {
        this.totalSalary = totalSalary;
    }

    /*calculateSalary method is the template for it's subclasses. it returns total salary*/
    public abstract void calculateSalary(HashMap<String,Integer[]> weeklyHoursMap);

    /*findSeverance method calculates severance payment.Severance payment calculated as
    (current year-the year that personnel starts)*20*0.8 */
    public double findSeverancePay() {
        return (2020 - yearOfStart) * 20 * 0.8;
    }

/* toString method method returns output attributes as a string*/
@Override
public String toString() {
    String[] nameSurnameArray=nameSurname.split(" ");
    return String.format(Locale.US,"%s : %s\n%s : %s\n%s : %s\n%s : %s\n%s : %s\n%s : %.2f",
    "Name",nameSurnameArray[0],"Surname",nameSurnameArray[1],
            "Registration Number", registrationNumber,"Position",position,
            "Year of Start",yearOfStart, "Total Salary",totalSalary);}


}
