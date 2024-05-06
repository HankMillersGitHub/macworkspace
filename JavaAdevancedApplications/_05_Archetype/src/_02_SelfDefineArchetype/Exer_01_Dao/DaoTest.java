package _02_SelfDefineArchetype.Exer_01_Dao;

import java.util.Iterator;

public class DaoTest {
    public static void main(String[] args) {
        DAO<User> dao = new DAO<>();
        User user1 = new User(123,18,"Hank");
        User user2 = new User(124,19,"Jerry");
        User user3 = new User(125,20,"Jack");
        User user4 = new User(126,21,"Jeny");
        dao.save("123",user1);
        dao.save("124",user2);
        dao.save("125",user3);
        dao.save("126",user4);
        System.out.println(dao.map.entrySet());
        System.out.println(dao.get("125"));
        dao.update("126",new User(127,90,"Lulu"));
        System.out.println(dao.map.entrySet());
        Iterator<User> iterator = dao.list().iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        dao.delete("125");
        System.out.println(dao.map.entrySet());
    }


}
