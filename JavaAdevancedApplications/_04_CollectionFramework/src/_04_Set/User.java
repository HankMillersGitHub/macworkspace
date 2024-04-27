package _04_Set;

import java.util.Objects;

public class User implements Comparable {
    String name;
    int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return age == user.age && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public User() {
    }

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        // 按照年龄大小排序
        if(o instanceof User){
            User u = (User) o;
            if((this.age - u.age) == 0){
                return this.name.compareTo(u.name);
            }else{
                return this.age - u.age;
            }
        }
        throw new RuntimeException("类型不匹配");
        // 按照name排序
/*        if(o instanceof User){
            User u = (User) o;
            return String.CASE_INSENSITIVE_ORDER.compare(u.name,this.name);
        }
        throw new RuntimeException("类型不匹配");*/
    }
}
