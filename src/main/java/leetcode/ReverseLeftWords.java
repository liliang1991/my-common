package leetcode;

/**
 * @Description 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。请定义一个函数实现字符串左旋转操作的功能。
 * 比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"
 *解题思路
 * 字符串切割成左右两个字符串，然后字符串 右+左
 * @Date 2023/2/9 下午2:38
 * @Created by Moon
 */
public class ReverseLeftWords {
    public String reverseLeftWords(String s, int n) {
        String left=s.substring(0,n);
        String right = s.substring(n);
        return right+left;
    }

    public static void main(String[] args) {
        ReverseLeftWords reverseLeftWords = new ReverseLeftWords();
        String s = "abcdefg";
        System.out.println(reverseLeftWords.reverseLeftWords(s, 2));

    }
}
