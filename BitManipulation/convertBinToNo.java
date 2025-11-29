package BitManipulation;

public class convertBinToNo {
    public static int binaryToDecimal(String b) {

        int ans = 0;
          int pow = 1;
        for (int i = b.length()-1; i >= 0; i--) {
          
            ans += pow * (b.charAt(i)-'0');
            pow = pow * 2;
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "100001";
System.out.println(binaryToDecimal(s));
    }
}
