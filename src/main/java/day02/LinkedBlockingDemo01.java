package day02;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * 演示阻塞队列的基本用法
 *     在java.util.concurrent包下面，提供了一个接口BlockingQueue
 *     该接口主要定义了两个方法(take,put),分别用于向阻塞队列中添加数据和获取数据
 *     该接口有两个主要的实现类，分别是LinkedBlockingQueue(底层实现是一个链表)
 *     和 ArrayBlockingQueue(底层实现是一个数组)
 * @author Tedu
 */
public class LinkedBlockingDemo01 {
    private static BlockingQueue<String> bq=new LinkedBlockingQueue<>();
    public static void main(String[] args){
        //创建消费者线程
        Thread t=new Thread(){
            @Override
            public void run(){
                try {
                    System.out.println("消费者线程准备从阻塞队列中获取数据....");
                    String data=bq.take();
                    System.out.println("消费者线程获取到的数据是:"+data);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        t.start();
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //main线程充当生产者线程
        try {
            bq.put("Hello");
            System.out.println("生产者线程向阻塞队列中添加了一些数据...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
