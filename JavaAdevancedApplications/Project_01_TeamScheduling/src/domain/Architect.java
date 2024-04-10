package domain;

public class Architect extends Designer{
    // 股票
    private int stock;

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Architect() {
    }

    public Architect(int id,String name, int age, double salary, Equipment equipment, double bonus, int stock) {
        super(id,name, age, salary, equipment, bonus);
        this.stock = stock;
    }
    @Override
    public String toString() {
        return getDetail() + "\t架构师\t" + getStatus() + "\t" + getBonus() + "\t" + getStock() + "\t" + getEquipment().getDescription();
    }

    @Override
    public String getDetailsForTeam() {
        return super.getDetailsForTeam() + "\t" + getStock();
    }
}
