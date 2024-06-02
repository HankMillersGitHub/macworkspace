package _03_stream;

import _02_reference.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/2 16:10
 */
public class EmployeeData {
    public static List<Employee> getEmployees(){
        List<Employee> list = new ArrayList<>();
        list.add(new Employee("马化腾",41));
        list.add(new Employee("马化腾",41));
        list.add(new Employee("马云",52));
        list.add(new Employee("任正非",54));
        list.add(new Employee("雷军",64));
        list.add(new Employee("张朝阳",24));
        list.add(new Employee("周鸿祎",65));
        list.add(new Employee("刘强东",67));
        list.add(new Employee("扎克伯格",34));
        list.add(new Employee("马斯克",35));
        list.add(new Employee("李彦宏",87));
        list.add(new Employee("比尔盖茨",67));
        return list;
    }
}
