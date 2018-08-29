package main.interfaces;

/**
 * [public] 修饰类
 * private protected 不可
 * 也是有分别
 * */
public interface Interfaces {
    public static final int i = 0; // 常量 [public static final] 修饰

    public void runMethod(); // 借口方法定义 [public]
    public static int run() { // 静态方法实现 [public]
        System.out.println(999);
        return 999;
    }
}
