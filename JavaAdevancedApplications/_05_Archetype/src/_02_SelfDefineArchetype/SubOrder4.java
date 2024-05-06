package _02_SelfDefineArchetype;
/**
 * 这也是范型类 基于父类范型参数为Integer的情况下，自身有一个E类型的范型参数e
 * */
public class SubOrder4<E> extends Order<Integer>{
    E e;

    public SubOrder4() {
    }

    public SubOrder4(E e) {
        this.e = e;
    }

    public SubOrder4(Integer integer, int orderId, E e) {
        super(integer, orderId);
        this.e = e;
    }
}
