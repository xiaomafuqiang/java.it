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

    }
}
