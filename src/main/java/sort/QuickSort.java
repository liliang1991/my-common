package sort;

public class QuickSort {
    public void quickSort(int[] a, int left, int right) {
        if (left < right) {
            int i, j, key;
            i = left;
            j = right;
            key = a[left];

            while (i < j) {
                while (i < j && a[j] > key) {
                    j--;
                }
                if(i<j){
                    a[i++] = a[j];

                }
                while (i < j && a[i] < key) {
                    i++;

                }
                if(i<j){
                    a[j--] = a[i];

                }
            }
            a[i]=key;
            quickSort(a,left,i-1);
            quickSort(a,i+1,right);


        }
    }

    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] a = {30, 40, 60, 10, 20, 50};
        //30,40,60,10,20,50 i=0;j=5

        //20,40,60,10,20,50 i=0;j=4
        //20,40,60,10,40,50 i=1,j=4
        //20.10,60,10,40,50 i=1,j=3
        //20,10,60,60,40,50 i=2,j=3
        quickSort.quickSort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }

    }

}
