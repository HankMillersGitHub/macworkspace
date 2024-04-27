package _05_other;

import java.math.BigInteger;
import java.util.Random;

public class OtherAPItest {
    public static void main(String[] args) {
        Random random = new Random();
        System.out.println(random.nextBoolean());
        int a = 22;
        while (a != 30){
            System.out.println(random.nextInt(21) + 10);
            a = random.nextInt(21) + 10;
        }
    }
}
