package BitManipulation;

public class converstNoToBin {

   public static String decToBinary(int n) {

      
        String bin = "";

        while (n != 1) {
            int rem = n % 2;
            bin += rem;
            n = n / 2;
        }

        bin+= "1";
        StringBuilder sb = new StringBuilder(bin);
        String ans = sb.reverse().toString();


        return ans.toString();
    }

    public static void main(String[] args) {
        int n = 33;
System.out.println(decToBinary(n));
    }

}
