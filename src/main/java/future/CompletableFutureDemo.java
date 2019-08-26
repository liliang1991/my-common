package future;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CountDownLatch;

public class CompletableFutureDemo {
    public static void main(String[] args)throws InterruptedException {
        long l = System.currentTimeMillis();
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() ->
        {

            System.out.println("执行耗时操作...");

             timeConsumingOperation();
            return 100;
        });
        completableFuture = completableFuture.thenCompose(i -> {
            return CompletableFuture.supplyAsync(() -> {
                System.out.println("在回调的回调中执行耗时操作...");
                timeConsumingOperation();
                return i + 100;
            });
        });
        completableFuture.whenComplete((result, e) ->
        {
            System.out.println("结果：" + result);
        });

        System.out.println("主线程运算耗时:" + (System.currentTimeMillis() - l) + " ms");
       new CountDownLatch(1).await();
    }
        static void timeConsumingOperation(){
            try
            {
                Thread.sleep(5000);
            }
            catch (Exception e){
                e.printStackTrace();
            }


        }

}
