package leetcode;

/**
 * @Description 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。
 * 在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字
 * 解题思路
 * 遍历数组，第一次遍历记录一个数组值与下标的差值，然后每次遍历看与前一次差值是否相等，来判断数组是否连续
 * @Date 2023/2/13 下午5:23
 * @Created by Moon
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int flag = 0;
            if (i == 0) {
                flag = nums[i] - i;
            } else if (flag == nums[i] - i) {
                continue;
            } else {
                return nums[i] - 1;
            }


        }
        return -1;
    }

    public static void main(String[] args) {
        int a[] = {0, 1, 2, 3, 4, 5, 6, 7, 9};
        MissingNumber missingNumber = new MissingNumber();
        System.out.println(missingNumber.missingNumber(a));

    }
}
