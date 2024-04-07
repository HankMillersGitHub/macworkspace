package service;

import domain.*;

import static service.Data.*;

public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];

        for (int i = 0; i < employees.length; i++) {
            // 获取通用属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Integer.parseInt(EMPLOYEES[i][4]);
            Equipment equipment;
            double bouns;
            // 根据第一个属性值对数组元素进行赋值
            switch (Integer.parseInt(EMPLOYEES[i][0])){
                case EMPLOYEE:
                    employees[i] = new Employee(id,name,age,salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id,name,age,salary,equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id,name,age,salary,equipment,bouns);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bouns = Double.parseDouble(EMPLOYEES[i][5]);
                    int stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id,name,age,salary,equipment,bouns,stock);
                    break;
            }

        }

    }
    // 包装Equipment类对象
    public Equipment createEquipment(int index){
        // 设备类型id
        int deviceTypeIndex = Integer.parseInt(EQIPMENTS[index][0]);
        // 设备
        String deviceName = EQIPMENTS[index][1];
        String deviceType = EQIPMENTS[index][2];
        return switch (deviceTypeIndex) {
            case PC -> new PC(deviceName, deviceType);
            case NOTEBOOK -> new NoteBook(deviceName, deviceType);
            case PRINTER -> new Printer(deviceName, deviceType);
            default -> throw new IllegalStateException("Unexpected value: " + deviceTypeIndex);
        };
    }
    public Employee[] getAllEmployees(){
        return employees;
    }
    public Employee getEmployee(int id) throws TeamException {
        for (Employee employee : employees) {
            if (id == employee.getId()) {
                return employee;
            }
        }
        // 执行到这里意味着没找到指定的员工
        throw new TeamException("No Trace Of This Person");
    }
}
