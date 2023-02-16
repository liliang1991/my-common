package leetcode;

/**
 * @Description 二维数组中的查找
 * 解题思路
 * 1：先遍历列，第一个元素如果大于target,表示后面的元素中没有target,直接返回
 * 2：然后二分查找行，找到对于元素返回true
 * leetcode 上解题思路
 * 1：倒序遍历行，每行第一个元素大于target,则遍历倒数第二行
 * 2：每行第一个元素小于target，则遍历此行第二列，依次循环
 * @Date 2023/2/16 下午6:54
 * @Created by Moon
 */
public class FindNumberIn2DArray {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0]>target){
                return false;
            }else{
                //遍历行
                int left =0;
                int right=matrix[i].length-1;
                while (left<=right){
                    int num=(left+right)/2;
                    if(matrix[i][num]==target){
                        return  true;
                    }else if(matrix[i][num]>target){
                        right=num-1;
                    }else{
                        left=num+1;
                    }

                }

            }
        }
        return false;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray findNumberIn2DArray=new FindNumberIn2DArray();
        int[][] matrix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(findNumberIn2DArray.findNumberIn2DArray(matrix,5));
    }
}