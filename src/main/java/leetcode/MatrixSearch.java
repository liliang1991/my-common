package leetcode;

/**
 * TODO 此题是借用leetcode代码，但思路已经明白，后续还需自己写
 * @Description 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * 解题思路
 * 深度优先搜索（DFS)
 * 举例
 * 有二维数组，
 * 'A','B','C','E'
 * 'S','F','C','S'
 * 'A','D','E','E'
 * 设有三个值 i,j,k, i和j为行和列，用来定位查找的元素下表，例如A 的 元素下表i=0;j=0;  k 为匹配到元素的个数，与word 个数一致，则全部匹配成功
 * 初始化i 和j 的值为0（左上角）,每次从上下左右进行匹配，匹配成功再依次递归匹配下一个元素，直到完全匹配成功
 * 注意点:匹配过一个元素，则把这个元素设为空，以标记这个元素已经匹配过，匹配全部完成然后还原各个元素
 *
 * @Date 2023/2/22 下午1:42
 * @Created by Moon
 */
public class MatrixSearch {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        // 判断传入参数的可行性 i 与图行数row比较，j与图列数col比较
        // i，j初始都是0，都在图左上角
        // k是传入字符串当前索引，一开始是0，如果当前字符串索引和图当前索引对应的值不相等，表示第一个数就不相等
        // 所以继续找第一个相等的数。题目说第一个数位置不固定，即路径起点不固定（不一定是左上角为第一个数）

        // 如果board[i][j] == word[k]，则表明当前找到了对应的数，就继续执行（标记找过，继续dfs 下上右左）
        if (i >= board.length || i < 0 || j >= board[0].length || j < 0 || board[i][j] != word[k]) return false;
        // 表示找完了，每个字符都找到了
        // 一开始k=0，而word.length肯定不是0，所以没找到，就执行dfs继续找。
        if (k == word.length - 1) return true;

        // 访问过的标记空字符串，“ ”是空格 '\0'是空字符串，不一样的！
        // 比如当前为A，没有标记找过，且A是word中对应元素，则此时应该找A下一个元素，假设是B，在dfs（B）的时候还是-
        // ->要搜索B左边的元素（假设A在B左边），所以就是ABA（凭空多出一个A，A用了2次，不可以），如果标记为空字符串->
        // 就不会有这样的问题，因为他们值不相等AB != ABA。
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) || dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) || dfs(board, word, i, j - 1, k + 1);
        // 还原找过的元素，因为之后可能还会访问到（不同路径）
        board[i][j] = word[k];
        return res;
    }

    public static void main(String[] args) {
        MatrixSearch matrixSearch = new MatrixSearch();

        char[][] board = new char[][]{{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCC";
        //  System.out.println(board[1][2]);
        System.out.println(matrixSearch.exist(board, word));


    }

}
