package com._01_example;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/25 08:45
 */
public class Person {
    private String name;
    public int age;

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
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
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
    public void sayhello(){
        System.out.println("hi i am a Person");
    }

    public Person() {
    }

    private String showNation(String nation){
        return "my country is " + nation;
    }
}
