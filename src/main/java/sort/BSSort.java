package sort;

public class BSSort {
    public int sort(int []a,int left,int right,int value){
        int i=left;
        int j=right;
        while (left<=right){
            int index=(right+left)/2;
            if(a[index]==value){
                return  a[index];
            }else if(a[index]<value){
                left=index+1;
            }else {
                right=index-1;
            }
        }
        return -1;

    }
    public static void main(String[] args) {
        int a[]={1,2,5,7,11};
        int value=7;
        BSSort bsSort=new BSSort();
        System.out.println(bsSort.sort(a,0,a.length-1,value));
        bsSort.sum(a);

    }

    public int sum(int... numbers) {
        //inside the method a variable argument is similar to an array.
        //number can be treated as if it is declared as int[] numbers;
        int sum = 0;
        for (int number: numbers) {
            sum += number;
        }
        return sum;
    }


}
