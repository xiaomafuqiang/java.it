package main;

import org.junit.Test;

public class Regexes {
    @Test
    public void run() {
        // 正则
        String s = "123456";
        boolean b = s.matches("\\d+");
        System.out.println(b);

    }
}
