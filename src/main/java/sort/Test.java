package sort;

public class Test {
    public static void quick_sort(int []a,int left,int right){
         if(left<right){
             int i=left;
             int j=right;
             int key=a[i];
             while (i<j){
                 while (i<j&&a[j]>key){
                     j--;

                 }
                 if(i<j) {
                     a[i++] = a[j];
                 }
                 while (i<j&&a[i]<key){
                     i++;
                 }
                 if(i<j) {
                     a[j--] = a[i];
                 }
             }
             a[i]=key;
             quick_sort(a,left,i-1);
             quick_sort(a,i+1,right);

         }
    }
    public static void main(String[] args) {
        int[] a={10,3,5,1,19,8};
        quick_sort(a,0,a.length-1);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }
    }
}
