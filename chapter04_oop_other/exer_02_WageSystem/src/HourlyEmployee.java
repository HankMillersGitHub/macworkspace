/**
 * @program: macWorkSpace
 * @ClassName HourlyEmployee
 * @description:
 * @author: HankMiller
 * @create: 2024-03-20 21:30
 * @Version 1.0
 **/
public class HourlyEmployee extends Employee{
    private int wage; // 单位小时的工资
    private int hour; // 月工作时间(小时)

    public HourlyEmployee() {
    }

    public HourlyEmployee(String name, int number, MyDate birthday, int wage, int hour) {
        super(name, number, birthday);
        this.wage = wage;
        this.hour = hour;
    }

    public int getWage() {
        return wage;
    }

    public void setWage(int wage) {
        this.wage = wage;
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }
    public int earnings(){
        return wage * hour;
    }

    @Override
    public String toString() {
//        return "HourlyEmployee[name = "+ getName() + ",number = " + getNumber() + ",birthday = "+getBirthday().toDateString()+"]";
        return "HourlyEmployee[" + super.toString() + "]";
    }
}
