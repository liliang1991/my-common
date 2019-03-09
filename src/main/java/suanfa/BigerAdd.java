package suanfa;

public class BigerAdd {
    public static String add(String a, String b) {
        a = new StringBuffer(a).reverse().toString();
        b = new StringBuffer(b).reverse().toString();
        int len1 = a.length();
        int len2 = b.length();
        StringBuffer result = new StringBuffer();

        if (len1 < len2) {
            for (int i = 0; i < (len2 - len1); i++) {
                a = a + "0";
            }
        } else {
            for (int i = 0; i < (len1 - len2); i++) {
                b = b + "0";
            }
        }
        int maxover = 0;

        for (int i = 0; i < a.length(); i++) {
            int value = 0;
            int num = Integer.parseInt(a.charAt(i) + "") + Integer.parseInt(b.charAt(i) + "");

            if (num > 10) {
                result.append(num - 10 +maxover);



                maxover = 1;
            }else {
                if(num+maxover>=10){
                    if(i==a.length()-1){
                        result.append(new StringBuffer((maxover+num)+"").reverse());


                    }else {
                        result.append(num + maxover - 10);
                        maxover = 1;
                    }
                }else{
                    result.append(num+maxover);
                    maxover=0;

                }

            }

        }
        return result.reverse().toString();
    }

    public static void main(String[] args) {
        String a = "99111";
        String b = "2222";
        System.out.println(add(a,b));
    }
}
