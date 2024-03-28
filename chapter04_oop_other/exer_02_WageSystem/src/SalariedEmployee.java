/**
 * @program: macWorkSpace
 * @ClassName SalariedEmployee
 * @description:
 * @author: HankMiller
 * @create: 2024-03-20 21:27
 * @Version 1.0
 **/
public class SalariedEmployee extends Employee{
    private int monthlySalary;

    public SalariedEmployee() {

    }

    /**
     * 一句话描述该方法的作用
     * @param name
     * @param number
     * @param birthday
     * @param monthlySalary
     * @author HankMiller
     * @Description // TODO
     * @data 2024/03/21 10:28
     **/
    public SalariedEmployee(String name, int number, MyDate birthday, int monthlySalary) {
        super(name, number, birthday);
        this.monthlySalary = monthlySalary;
    }

    @Override
    public int earnings() {
        return monthlySalary;
    }
    public String toString(){
//        return "SalariedEmployee[name = " + getName() + ",number = " + getNumber() + ",birthday = " + getBirthday().toDateString() + "]";
        return "SalariedEmployee["+ super.toString() +"]";
    }
}
