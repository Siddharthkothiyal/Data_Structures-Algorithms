package BitManipulation;

public class powerofTwo {
     public static boolean rightMostBitRemove(int n ){
       if ((n &  (n-1))== 0){
        return true;
       }

       return false;
    }

    public static void main(String[] args) {
        int n = 12;
  

        System.out.println(rightMostBitRemove(n));
    } 
}
