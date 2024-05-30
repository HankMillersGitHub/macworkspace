package com._03_reflectapply.data;

import javax.management.relation.RoleUnresolved;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/27 08:09
 */
@MyAnnotation("t_persons")
public class Person extends Creature<String> implements Comparable<Person>,MyInterface{
    private String name;
    public int age = 1;
    @MyAnnotation("info")
    private static String info;

    public Person() {
        System.out.println("Person()...");
    }
    protected Person(int age){
        this.age = age;
    }
    private Person(String name,int age){
        this.name = name;
        this.age = age;
    }
    public void show() throws RuntimeException,ClassNotFoundException{
        System.out.println("你好，我是一个Person");
    }
    @MyAnnotation(value="show_nation")
    private String showNation(String nation,int age){
        System.out.println("showNation...");
        return "my country is " + nation + ",生活了" + age +  "年。";
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return 0;
    }

    @Override
    public void method() {

    }
    public static void showInfo(){
        System.out.println("i am a Person");
    }
}
