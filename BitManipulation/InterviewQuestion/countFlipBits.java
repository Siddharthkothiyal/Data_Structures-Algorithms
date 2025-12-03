package BitManipulation.InterviewQuestion;

public class countFlipBits {
      public static int minBitFlips(int start, int goal) {
        int ans= (start ^ goal);
int count=0;
        for(int i=0 ; i<31 ;i++ ){
            if((ans & (1<<i)) !=0){
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int start=10;
        int goal=7;

        System.out.println(minBitFlips(start, goal));
    }
}
