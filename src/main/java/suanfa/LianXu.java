package suanfa;
/*
连续和最大的组合
 */
public class LianXu {
    public static void main(String[] args) {
        int a[]={-1,8,-10,3,7,-15};
        int sum=0;
        int max=0;
        for(int i=0;i<a.length;i++){
            if(sum<0){
                sum=a[i];
            }else{
                sum+=a[i];
            }
            if(sum>max){
                max=sum;
            }

        }
        System.out.println(max);
    }
}
