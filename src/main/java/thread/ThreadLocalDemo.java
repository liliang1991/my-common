package thread;

import java.util.concurrent.atomic.AtomicInteger;

public class ThreadLocalDemo {
    public static void main(String[] args) {
       for(int i=0;i<3;i++){
           Thread thread=new Thread(){
               @Override
               public void run() {
                   System.out.println("当前线程:"+Thread.currentThread().getName()+",已分配ID:"+ThreadId.get());
               }
           };
           thread.start();
       }
    }
   static  class ThreadId
   {
        final static AtomicInteger threadId=new AtomicInteger(0);
       static ThreadLocal<Integer> threadLocal=new ThreadLocal<Integer>(){
            @Override
            protected Integer initialValue() {
                return threadId.getAndIncrement();
            }
        };
       public static int get() {
           return threadLocal.get();
       }
    }

}
