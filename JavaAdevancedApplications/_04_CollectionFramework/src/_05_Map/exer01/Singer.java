package _05_Map.exer01;

import java.util.Objects;

public class Singer implements Comparable{
    String name;
    int age;

    public Singer(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Singer singer)) return false;
        return age == singer.age && Objects.equals(name, singer.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
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

    @Override
    public int compareTo(Object o) {
        if(o == this){
            return 0;
        }
        if(o instanceof Singer){
            Singer singer = (Singer) o;
            if(singer.age == this.age){
                return 0;
            }
            return singer.name.compareTo(this.name);
        }
        throw new RuntimeException("类型不匹配");
    }
}
