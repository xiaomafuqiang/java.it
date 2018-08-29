package main.interfaces;

/**
 * [public] 修饰类
 * private protected 不可
 * 也是有分别
 * */
public interface Interfaces {
    public static final int i = 0; // 常量 [public static final] 修饰

    public abstract void runMethod(); // 借口方法定义 [public abstract]
    public static int run() { // 静态方法实现 [public]
        System.out.println(999);
        return 999;
    }
}

interface A {
    A run();
}

interface B extends A {
    B run();

    B say();
}

class Crun implements B {

    @Override
    public B run() {
        System.out.println("run");
        return this;
    }

    @Override
    public B say() {
        System.out.println("say");
        return this;
    }

    public static void main(String[] args) {
        Crun crun = (Crun) new Crun().say();
        new Crun().say().run();
        System.out.println();
    }
}
