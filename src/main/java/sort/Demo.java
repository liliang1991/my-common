package sort;

public class Demo {
    public void quick_sort(int[] a,int left,int right){

     if(left<right){
         int i=left;
         int j=right;
         int x=a[left];
         while (i<j) {
             while (i< j && a[j] > x) {
                 j--;
             }
             if (i < j) {
                 a[i++] = a[j];
             }
             while (i < j && a[i] < x) {
                 i++;
             }
             if (i< j) {
                 a[j--] = a[i];
             }
         }
         a[i]=x;
         quick_sort(a,left,i-1);
         quick_sort(a,i+1,5);
     }

    }
    public static void main(String[] args) {
         Demo demo = new Demo();
        int[] a = {30, 40, 60, 10, 20, 50};
        //30,40,60,10,20,50 i=0;j=5

        //20,40,60,10,20,50 i=0;j=4
        //20,40,60,10,40,50 i=1,j=4
        //20.10,60,10,40,50 i=1,j=3
        //20,10,60,60,40,50 i=2,j=3
        demo.quick_sort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}
