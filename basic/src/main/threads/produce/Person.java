package main.threads.produce;
import java.util.concurrent.locks.*;

class resource //将共有资源封装
{
    private String name;
    private int count=1;
    private boolean flag=false;
    Lock lock=new ReentrantLock();
    Condition con=lock.newCondition();
    Condition pro=lock.newCondition();

    public void set(String name)//同步set方法
    {
        lock.lock();
        try
        {

            while (flag)//如果为假，生产烤鸭，如果为真，等待
            {

                try{pro.await();}catch(InterruptedException e){}
            }
            this.name=name+count;
            count++;
            System.out.println(Thread.currentThread().getName()+".生产者..."+this.name);
            flag=true;
            con.signal();//防止死锁问题，唤醒线程池中的全部线程

        }
        finally
        {
            lock.unlock();
        }
    }
    public void out()//同步out方法
    {
        lock.lock();
        try
        {

            while(!flag)//如果为真，消费烤鸭，如果为假，等待
            {

                try{con.await();}catch(InterruptedException e){}
            }
            System.out.println(Thread.currentThread().getName()+".....消费者"+this.name);
            flag=false;
            pro.signal();//防止死锁问题，唤醒线程池中全部线程

        }
        finally
        {
            lock.unlock();
        }
    }

}

class producer implements Runnable
{
    private resource r;//不同的方法访问一个资源
    producer(resource r)
    {
        this.r=r;
    }
    public void run()
    {
        while (true)
        {
            r.set("烤鸭");
        }
    }
}
class consumer implements Runnable
{
    private resource r;
    consumer(resource r)
    {
        this.r=r;
    }
    public void run()
    {
        while (true)
        {
            r.out();
        }

    }
}




class test
{
    public static void main(String[] args)
    {
        resource r=new resource();//为不同的方法设置同一个资源
        producer p1= new producer(r);
        consumer c1=new consumer(r);
        //创造线程
        Thread t1=new Thread(p1);
        Thread t2=new Thread(p1);
        Thread t3=new Thread(c1);
        Thread t4=new Thread(c1);
        //开启线程
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}