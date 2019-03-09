package message;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static ReentrantLock lock = new ReentrantLock();
    public static Condition prod = lock.newCondition();
    public static Condition con = lock.newCondition();
    public static void main(String[] args) {

        List list=new ArrayList();
        int len=3;
        Producer producer=new Producer(list,len);
        Consumer consumer=new Consumer(list,len);
        new Thread(producer).start();
        new Thread(consumer).start();
    }
}
