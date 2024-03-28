public class Main {
    public static void main(String[] args) {
        Vehicle[] vehicles = new Vehicle[3];
        vehicles[0] = new Bicycle("捷安特","红色");
        vehicles[1] = new Car("玛莎拉蒂","蓝色","京A88888");
        vehicles[2] = new ElectricVehicle("雅迪","绿色");
        Developer d = new Developer("hank",27);
        d.takingVehicle(vehicles[0]);
        d.takingVehicle(vehicles[1]);
        d.takingVehicle(vehicles[2]);
    }
}