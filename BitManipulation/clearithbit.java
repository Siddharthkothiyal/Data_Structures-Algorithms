package BitManipulation;

public class clearithbit {
      public static int bitClear(int n , int i){
       return (n &  (~(1<<i)));
    }

    public static void main(String[] args) {
        int n = 7;
        int i=1;

        System.out.println(bitClear(n, i));
    }
}
