package com._03_reflectapply.apply1;

import com._03_reflectapply.data.Person;
import org.junit.Test;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/5/27 08:23
 */
public class NewInstanceTest {
    @Test
    public void test1() throws InstantiationException, IllegalAccessException {
        Class<Person> clazz = Person.class;
        Person person = clazz.newInstance();
        System.out.println(person);
    }
}
