package main.threads;

import org.junit.Test;

public class Runner {
    @Test
    public void runThread() {
//        MyThread myThread = new MyThread();
//        myThread.start();
        new MyThread().start();


        new Thread(new RunnableThread()).start();

    }
}
