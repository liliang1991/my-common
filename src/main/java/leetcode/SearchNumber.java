package leetcode;

/**
 * @Description 在排序数组中查找数字
 * 解题思路
 * 二分查找法，然后计算出现了多少次
 * @Date 2023/2/9 下午7:14
 * @Created by Moon
 */
public class SearchNumber {
    public int search(int[] nums, int target) {
        int count = 0;
        int left = 0;
        int right = nums.length;
        while (left < right) {
            int i = (left + right) / 2;
            if (nums[i] == target) {
                count++;
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                for (int j = i - 1; j > 0; j--) {
                    if (nums[j] == target) {
                        count++;
                    } else {
                        break;
                    }
                }
                return count;

            } else if (nums[i] < target) {
                left = i;
            } else if (nums[i] > target) {
                right = i;
            }

        }
        return -1;
    }

    public static void main(String[] args) {
        int nums[] = {1, 3, 3, 3, 3, 5, 7, 9};
        SearchNumber searchNumber = new SearchNumber();
        System.out.println(searchNumber.search(nums, 3));
    }
}
