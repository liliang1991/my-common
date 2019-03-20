package common.cureent;

import java.util.concurrent.CountDownLatch;

public class CountDowmLatchDemo {

    public static void main(String[] args) {
        final CountDownLatch countDownLatch=new CountDownLatch(3);
        new Thread(){
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                countDownLatch.countDown();
            }
        }.start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("子线程"+Thread.currentThread().getName()+"正在执行");
                countDownLatch.countDown();
            }
        }.start();
        System.out.println("等待2个子线程执行完毕...");
        try {
            countDownLatch.await();

        }catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("2个子线程已经执行完毕");
    }
}
