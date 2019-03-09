package suanfa;

public class FeiBoNa {
    public static int fib(int n){
        int num2=1;
        int num1=1;
        int sum=0;
        if(n==1||n==2){
            sum=1;
        }else {

            for (int i = 2; i < n; i++) {
                sum = num1 + num2;
                num2 = num1;
                num1 = sum;
            }
        }

        return sum;
    }
    public static void main(String[] args) {
       for(int i=1;i<10;i++){
           System.out.println(fib(i));
       }
    }
}
