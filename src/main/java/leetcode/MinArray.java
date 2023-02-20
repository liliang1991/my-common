package leetcode;

/**
 * @Description 旋转数组的最小数字
 * 解题思路
 * 二分查找,寻找 右排序数组 的首个元素x
 * 如果 numbers[right] < numbers[m]，x 一定在m 的右边，封闭左区间，及执行left=m+1
 * 如果numbers[right] > numbers[m]，x 一定在m 的左边，封闭右区间，即执行 right=m,
 * 举例有数组 {3,4,5,1,2}
 * 第一次遍历 m=2, numbers[m]=5,numbers[right]<5 则 过滤掉m左边的元素 left=m(2)+1 left=3
 * 第二次遍历 m=（3+4）/2, m=3 此时 numbers[right]>numbers[m] ,right=m right=3
 * 第三次：left =3.right=3,不符合left<right,退出循环
 * @Date 2023/2/17 下午5:56
 * @Created by Moon
 */
public class MinArray {
    public int minArray(int[] numbers) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int m = (left + right) / 2;
            if (numbers[right] < numbers[m]) {
                left = m + 1;
            } else if (numbers[right] > numbers[m]) {
                right = m;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        int[] numbers = new int[]{3, 4, 5, 1, 2};
        MinArray minArray = new MinArray();
        System.out.println(minArray.minArray(numbers));
    }
}
