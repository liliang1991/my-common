package message;

import java.util.List;

public class Consumer implements Runnable {
    int length;
    List list;
    public Consumer(List list,int length){
        this.list=list;
        this.length=length;
    }
      public Consumer(){}
    @Override
    public void run() {
        while (true) {
        synchronized (list) {

                try {
                    if (list.size() == 0) {
                        list.notifyAll();
                      list.wait();
                    }
                        Object num = list.remove(0);
                        System.out.println(list.size()+"消费======" + num);

                } catch (Exception e) {
                }

            }
        }
    }
}
