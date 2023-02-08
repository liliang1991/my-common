package leetcode;

/**
 * @Description  替换空格
 * @Date 2023/2/8 下午6:44
 * 解题思路
 *按照空格切分成数组，然后进行拼接
 * @Created by Moon
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        StringBuffer sb = new StringBuffer();
        String result[] = s.split(" ");
        for (int i = 0; i < result.length; i++) {
            if (i < result.length - 1) {
                sb.append(result[i]+"%20");
            }else{
                sb.append(result[i]);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ReplaceSpace replaceSpace=new ReplaceSpace();
        System.out.println(replaceSpace.replaceSpace("We are happy."));
    }
}
