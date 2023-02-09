package leetcode;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;

/**
 * @Description 数组中重复的数字
 * 解题思路
 * 定义一个hashset,遍历数组，哈希里面有元素则是重复元素返回，否则添加到哈希
 * @Date 2023/2/9 下午5:44
 * @Created by Moon
 */
public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        Set set=new HashSet();
        for (int i=0;i<nums.length;i++){
            if(set.contains(nums[i])){
                return  nums[i];
            }else {
                set.add(nums[i]);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
     FindRepeatNumber findRepeatNumber=new FindRepeatNumber();
     int a[]= new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(findRepeatNumber.findRepeatNumber(a));
    }
}
