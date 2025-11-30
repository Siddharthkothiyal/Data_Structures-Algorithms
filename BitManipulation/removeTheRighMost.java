package BitManipulation;

public class removeTheRighMost {

      public static int rightMostBitRemove(int n , int i){
       return (n &  (n-1));
    }

    public static void main(String[] args) {
        int n = 9;
        int i=2;

        System.out.println(rightMostBitRemove(n, i));
    }
}

