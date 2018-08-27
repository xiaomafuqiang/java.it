package main;

import java.util.Random;

public class RandomDemo {
    public static void main(String[] args) {
        Random random = new Random();

        int i = random.nextInt(100); // [0, bound) 之间值
        System.out.println(i);
    }
}
