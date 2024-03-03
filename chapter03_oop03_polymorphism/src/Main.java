public class Main {
    public static void main(String[] args) {
        // 多态性之前的写法
/*        Man man = new Man();
        Male male = new Male();
        man.eat();
        man.sleep();
        man.earnMoney();
        male.eat();
        male.sleep();
        male.goShopping();*/

        // 子类对象的多态性
        Person p = new Male();
        /* 多态性的应用：虚拟方法调用
            在多态的场景下，调用方法时：
                编译时，认为方法是左边声明的父类的类型的方法(被重写的方法)
                执行时，实际执行的是子类重写父类的方法
                简称为：编译看左边，运行看右边
         */
        p.eat();
        p.sleep();
        // 测试属性是否适用于多态性
        System.out.println(p.id);
    }
}