package BitManipulation;

public class checkIthbitSet {

    public static boolean checkbitSet(int n , int i){
        if ((n & (1 << i)) != 0) {

            return true;
        }

        return false;
    }


    public static void main(String[] args) {
        int n = 13;
        int i=2;
        System.out.println(checkbitSet(n, i));
    }
    
}
