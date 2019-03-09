package xiancheng;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Schudle {
    ScheduledExecutorService executor= Executors.newScheduledThreadPool(1);
    public void test(){
        executor.scheduleAtFixedRate(new Runnable() {
            public void run() {
                System.out.println("aaaa");
            }
        },0,1, TimeUnit.MICROSECONDS);
    }
    public static void main(String[] args) {
          Schudle schudle=new Schudle();
          schudle.test();
    }
}
