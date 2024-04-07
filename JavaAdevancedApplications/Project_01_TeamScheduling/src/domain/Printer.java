package domain;

public class Printer implements Equipment{
    // 打印机名称
    private String name;
    // 打印机类型
    private String type;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Printer() {
    }

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getDescription() {
        return getName() + "(" + getType() + ")";
    }
}
