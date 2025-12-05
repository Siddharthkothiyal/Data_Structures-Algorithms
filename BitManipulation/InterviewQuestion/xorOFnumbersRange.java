package BitManipulation.InterviewQuestion;

public class xorOFnumbersRange {
      public static int findRangeXOR(int l, int r) {

        int xor=l;
         for (int i = l+1; i <= r; i++) {
xor= xor ^ i;
            
         }

         return xor;
    }

    public static void main(String[] args) {
        int  L = 1 , R = 3;
        System.out.println(findRangeXOR(L, R));

    }
    
}
