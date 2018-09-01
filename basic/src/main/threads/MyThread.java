package main.threads;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(getClass().getName());
    }
}
