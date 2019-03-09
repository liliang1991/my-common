package message;

import java.util.List;
import java.util.Random;

public class Producer implements Runnable {
    int length;
    List list;

    public Producer(List list, int length) {
        this.list = list;
        this.length = length;
    }

    public Producer() {

    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                try {
                    Random r = new Random();
                    if (list.size() >= length) {
                          list.notifyAll();
                          list.wait();
                    }
                        int num = r.nextInt();
                        list.add(num);
                        System.out.println(list.size() + "生产了" + num);


                } catch (InterruptedException e) {

                }


            }
        }
    }
}
