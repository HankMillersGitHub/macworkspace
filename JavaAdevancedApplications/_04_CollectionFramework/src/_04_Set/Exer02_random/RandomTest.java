package _04_Set.Exer02_random;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class RandomTest {
    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        int size = 0;
        while (size < 10){
            Random random = new Random();
            set.add(random.nextInt(20) + 1);
            if(set.size() == size + 1){
                size++;
            }
        }
        System.out.println(set);
    }
}
