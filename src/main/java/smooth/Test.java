package smooth;

import java.util.Date;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Test {
    Timer timer=new Timer();
    public Test(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("aaa");
            }
        }, 1, 10000);
    }

    public static void main(String[] args) {
        Test t=new Test();



    }
}
