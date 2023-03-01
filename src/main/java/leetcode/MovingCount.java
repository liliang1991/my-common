package leetcode;

/**
 * @Description 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 解题思路
 * 深度优先遍历 DFS
 * 注意点1:已经走过的格子必须标记,避免重复走
 *      2：数位之和计算逻辑 %10 得到 个位数，/10 删除个位数，依次循环相加
 * @Date 2023/2/25 上午10:35
 * @Created by Moon
 */
public class MovingCount {
    public int movingCount(int m, int n, int k) {
        int[][] board = new int[m][n];

        return dfs(board, m, n, 0, 0, k);
    }

    public int dfs(int[][] board, int m, int n, int s1, int s2, int k) {
        if (s1 >= m || s2 >= n || sum(s1) + sum(s2) > k || board[s1][s2] < 0) {
            return 0;
        }

//        if (i > 0 && j > 0) {
//            if (i == j) {
//                i--;
//            }
////             else if (i > j) {
////                i--;
////            }
//        }
//        System.out.println("=============");

        System.out.println("s1=====" + s1);
        System.out.println("s2====" + s2);
        board[s1][s2] = -1;
        return 1 + dfs(board, m, n, s1 + 1, s2, k) + dfs(board, m, n, s1, s2 + 1, k);
//        if (sum <= k) {
//            count++;
//           // return true;
//        } else {
//            return false;
//        }


    }

    private int sum(int n) {
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        MovingCount movingCount = new MovingCount();
        int m = 3;
        int n = 2;
        System.out.println(movingCount.movingCount(2, 3, 3));
        //数位求和测试
        // System.out.println(movingCount.sum(125));


    }
}
