package Arrays;

import java.util.Arrays;

public class stringCompression {
    public static  int compress(char[] chars) {

        int index = 0;
        for (int i = 0; i < chars.length; i++) {

            char ch = chars[i];
            int count = 0;

            while (i < chars.length && chars[i] == ch) {
                count++;
                i++;
            }

          

            if (count == 1) {
                chars[index++] = ch;
            } else {
                chars[index++] = ch;
                String str =  String.valueOf(count);;

                for (char dig : str.toCharArray()) {
                    chars[index++] = dig;
                }

            }

            i--;

        }

        return index;

    }

    public static void main(String[] args) {
        char [] charss= {'a','a', 'a' ,'b','c','c','c'};

        System.out.println(compress(charss));

    }
}
