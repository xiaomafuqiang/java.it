package main;

import org.junit.Test;

public class Types {
    @Test
    // ** 默认数字是int型, Integer Number too large
    // 如果定义其他类型需要加上标识
    public void assignValue() {
        long i = 100000000000L;
        // i = 100000000000;
        // i = new Long(1000000000000);
        float f = 10000000000F;
        // f = 10000000000;
        byte b = Byte.MAX_VALUE;
    }

    @Test
    // ** type cast
    public void typeCast() {

        // 较小
        short a = 10;
        Byte b = 9;
        // byte y = (a + b); // 容量不足
        // short s = (a + b); // 上类型默认返回 int
        short ss = (short)(a + b); // 默认返回 int
        long l = (a + b); // 可以用较大接收

        // 较大
        long c = 100L;
        // int bi = a + c; // 返回两者较大 ->long
        long bl = a + c;

        // 溢出
        int d = Integer.MAX_VALUE;
        int e = d + a;
        System.out.println(e); // -2147483639

    }

    @Test
    public void Boxing() {
        // string to int
        Integer ints = new Integer(6);
        System.out.println(ints.intValue());

        // int to string
        System.out.println(ints.toString());
        System.out.println(Integer.toString(50));

        // string to int
        ints = new Integer("10");
        System.out.println(ints);


    }
}
