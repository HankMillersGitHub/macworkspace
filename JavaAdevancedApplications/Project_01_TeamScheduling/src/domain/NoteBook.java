package domain;

public class NoteBook implements Equipment{
    // 笔记本型号
    private String model;
    // 笔记本价格
    private String price;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getPrice() {
        return price;
    }

    public NoteBook() {
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public NoteBook(String model, String price) {
        this.model = model;
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }

}
