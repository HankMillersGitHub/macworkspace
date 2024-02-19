public class Heisenberg extends Person {
    private String name;
    private int age;

    public Heisenberg() {
        super("Hank",18);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void sayMyName() {
        System.out.println("Heisenberg!");
    }

    @Override
    public void sayHello() {
        /**
         * 一句话描述该方法的作用
         * @author HankMiller
         * @Description // TODO
         * @data 2024/02/18 17:43
         * @param
         * @return
         **/
        System.out.println("sry can you repeat");
    }

    public void money() {
        /**
         * 一句话描述该方法的作用
         * @param a
         * @return int
         * @author HankMiller
         * @Description // TODO
         * @data 2024/02/18 17:45
         **/
        // 调用父类中的sayHello方法
        super.sayHello();
    }
}
