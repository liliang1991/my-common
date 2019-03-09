package sort;

public class MaoPaoSort {
    public static void maopao(int [] a){
        for(int i=0;i<a.length;i++){
            for(int j=1;j<a.length-i;j++){
                if(a[j]<a[j-1]){
                    int tmp=a[j-1];
                    a[j-1]=a[j];
                    a[j]=tmp;

                }
            }
        }
    }
    public static void main(String[] args) {
        int[] a = {30, 40, 60, 10, 20, 50};
        maopao(a);
        for(int i=0;i<a.length;i++){
            System.out.println(a[i]);
        }

    }
}
