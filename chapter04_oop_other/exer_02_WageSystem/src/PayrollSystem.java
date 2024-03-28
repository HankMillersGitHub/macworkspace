import java.util.Scanner;

public class PayrollSystem {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int scannerNum = scan.nextInt();
        Employee[] employees = new Employee[3];
        employees[0] = new HourlyEmployee("Hank",1001,new MyDate(1998,5,15),50,50);
        employees[1] = new HourlyEmployee("Miller",1002,new MyDate(1976,4,28),60,77);
        employees[2] = new SalariedEmployee("Hank",1003,new MyDate(2000,7,30),9000);
        for (Employee employee : employees) {
            if (scannerNum == employee.getBirthday().getMonth()) {
                System.out.println(employee.toString() + "原工资为:" + employee.earnings() + ",加一百工资");
            }else{
                System.out.println(employee.toString() + "原工资为:" + employee.earnings() + ",不加工资");
            }
        }
        scan.close();
    }
}