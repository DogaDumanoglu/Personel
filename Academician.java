public abstract class Academician extends Personnel {
    //This class is the template for the faculty member class and the research assistant class.
    private int baseSalary;
    private double ssBenefits;

    public Academician(String nameSurname, String registrationNumber, String position, int yearOfStart) {
        super(nameSurname,registrationNumber,position,yearOfStart);
        this.baseSalary = 2600;

    }
    public int getBaseSalary() { return baseSalary;}

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    /*setSsBenefits method sets special service benefits.
    Special service benefits consists of a certain proportion of base salary.*/

    public void setSsBenefits(double baseSalary,double ssBenefitRatio) {
        this.ssBenefits=baseSalary*ssBenefitRatio;
    }

    public double getSsBenefits() {
        return ssBenefits;
    }
}
