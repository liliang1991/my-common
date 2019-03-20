package fork;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

public class ForkJoinTest extends RecursiveTask<Integer>{
    private int start;
    private int end;
    public  ForkJoinTest(int start,int end){
        this.start=start;
        this.end=end;
    }
    @Override
    protected Integer compute() {
        int sum=0;
        boolean canCompute = (end - start) <= 2;
        if(canCompute){
            for (int i=start; i<=end; i++)
            {
                sum += i;
            }
        }else{
            int mid=(start+end)/2;
            ForkJoinTest leftTask = new ForkJoinTest(start, mid);
            ForkJoinTest rightTask=new ForkJoinTest(mid+1,end);
            leftTask.fork();
            rightTask.fork();
            int leftResult = leftTask.join();
            int rightResult=rightTask.join();
            sum=leftResult+rightResult;

        }

        return sum;
    }

    public static void main(String[] args)throws Exception {
        ForkJoinPool forkJoinPool=new ForkJoinPool();
        ForkJoinTest forkJoinTest=new ForkJoinTest(1,10);
        ForkJoinTask<Integer> result=forkJoinPool.submit(forkJoinTest);
        System.out.println(result.get());
    }
}
