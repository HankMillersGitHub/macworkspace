/**
 * @program: macWorkSpace
 * @ClassName Employee
 * @description:
 * @author: HankMiller
 * @create: 2024-03-20 21:21
 * @Version 1.0
 **/
abstract public class Employee {
private String name;
private int number;
private MyDate birthday;

    public Employee() {
    }

    public Employee(String name, int number, MyDate birthday) {
        this.name = name;
        this.number = number;
        this.birthday = birthday;
    }
    public abstract int earnings();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public MyDate getBirthday() {
        return birthday;
    }

    public void setBirthday(MyDate birthday) {
        this.birthday = birthday;
    }

    public String toString(){
        return "name = " + name + ",number = " + number + ",birthday = " + birthday.toDateString();
    }
}
