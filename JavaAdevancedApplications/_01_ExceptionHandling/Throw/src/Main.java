public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        try{
            Person p = new Person();
            p.regit(-1);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
    }
}
class Person{
    int id;

    public void regit(int id) {
        if(id > 0){
            this.id = id;
        }else{
//            throw new RuntimeException("illegal input");
            throw new BelowZeroException("your number is below zero");
        }
    }
}