package main.interfaces;

public abstract class AbsClass {
    /* # private*/ protected abstract void run(); // abstract 方法不可以 [private] 否则不能集成覆盖->无用, 其他按需正常
    // abstract void run(); // 包访问权, 类的 public 无用了
    public abstract void run(int i); // abstract 方法不可以 [private] 否则不能集成无用
}

interface J {
    void run();

    void m();
}

abstract class AbsA implements Interfaces {
    // public abstract void run();
}
