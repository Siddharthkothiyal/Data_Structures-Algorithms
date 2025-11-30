package BitManipulation;

public class countSetBits {
    public static int countSetBitsssss(int n) {
    int count = 0;

    while (n > 0) {
        n = n & (n - 1);  // removes the last set bit
        count++;
    }

    return count;
}

    public static void main(String[] args) {
        int n = 12;
  

        System.out.println(countSetBitsssss(n));
    } 
}
