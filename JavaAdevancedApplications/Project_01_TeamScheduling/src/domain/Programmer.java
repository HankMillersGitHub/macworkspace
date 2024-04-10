package domain;

import service.Status;

public class Programmer extends Employee{
    // 开发团队的tid
    private int memberId;
    //
    private Status status = Status.FREE;
    private Equipment equipment;

    public int getMemverId() {
        return memberId;
    }

    public void setMemverId(int memberId) {
        this.memberId = memberId;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public Programmer() {
    }

    public Programmer(int id,String name, int age, double salary, Equipment equipment) {
        super(id,name, age, salary);
        this.equipment = equipment;
    }
    @Override
    public String toString() {
        return super.toString() + "\t程序员\t" + status + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam(){
        // TID/ID name age salary employee gift stock
        return getMemverId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
    }
}
