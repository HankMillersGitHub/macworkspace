package com._03_reflectapply.data;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/27 08:08
 */
public class Creature<String> {
    boolean gender;
    public int id;
    public void breath(){
        System.out.println("呼吸");
    }
    private void info(){
        System.out.println("我是一个生物");
    }
}
