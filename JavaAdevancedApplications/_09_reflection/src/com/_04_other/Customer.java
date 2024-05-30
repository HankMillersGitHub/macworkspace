package com._04_other;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/30 09:48
 */
@Table(value="t_customer")
public class Customer {
    @Colum(columName = "cust_name",columType = "varchar(15)")
    private String name;
    @Colum(columName = "cust_age",columType = "int")
    public int age ;

    public Customer() {
    }

    public Customer(int age) {
        this.age = age;
    }

    public Customer(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
