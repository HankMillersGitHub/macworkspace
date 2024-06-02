package _01_lambda.MyFunction;

import org.junit.Test;

/**
 * @Description:
 * @auther mazhonghao
 * @date 2024/6/1 18:51
 */
public class MyTest {
    @Test
    public void test1(){
        MyFunction mf = (o1,o2) -> o1.compareTo(o2);

        System.out.println(mf.method(1,2));
    }
}
