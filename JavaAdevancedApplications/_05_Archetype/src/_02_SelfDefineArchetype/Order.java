package _02_SelfDefineArchetype;

public class Order <T>{
    // 声明了类的范型参数以后就可以在类的内部使用范型参数
    T t;
    int orderId;

    @Override
    public String toString() {
        return "Order{" +
                "t=" + t +
                ", orderId=" + orderId +
                '}';
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public Order(T t, int orderId) {
        this.t = t;
        this.orderId = orderId;
    }

    public Order() {
    }
}
