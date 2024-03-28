/**
 * @program: macWorkSpace
 * @ClassName Developer
 * @description:
 * @author: HankMiller
 * @create: 2024-03-25 09:48
 * @Version 1.0
 **/
public class Developer {
    private String name;
    private int age;

    public Developer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Developer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

/**
 * 上班乘坐的交通工具
 * @param vehicle
 * @author HankMiller
 * @Description // TODO
 * @data 2024/03/25 09:49
 **/
    public void takingVehicle(Vehicle vehicle){
        vehicle.run();
    }
}
