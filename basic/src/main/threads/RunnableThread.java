package main.threads;

public class RunnableThread implements Runnable {
    @Override
    public void run() {
        System.out.println(getClass().getName() + ":::" + Thread.currentThread().getName());
    }
}
