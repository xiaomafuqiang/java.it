package main;

import org.junit.Test;

import java.util.Random;
import java.util.Scanner;

public class RandomDemo {
    @Test
    public void demo() {
        Random random = new Random();

        int i = random.nextInt(100); // [0, bound) 之间值
        System.out.println(i);
    }

    /**
     * 猜数字
     * */
    public static void main(String[] args) throws InterruptedException {
        Random r = new Random();
        Scanner s = new Scanner(System.in);

        int guessValue = r.nextInt(10);

        while (true) {
            int is = s.nextInt();
            if (is == guessValue) {
                System.out.println("--------------- ========= ----------------");
                Thread.sleep(10000);
                System.exit(0);
            }
            String msg = is > guessValue ? "大了" : "小了";
            System.out.println(msg);
        }

    }
}
