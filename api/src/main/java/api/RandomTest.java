package jdk.api;

import org.junit.Test;

import java.util.Random;

public class RandomTest {

    @Test
    public void test1 () {
        for (int i = 1; i <11 ; i++) {
            Random random = new Random();
            int ran = random.nextInt(10);
            System.out.println(ran+1);
        }

    }
}
