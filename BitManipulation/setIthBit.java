package BitManipulation;

public class setIthBit {
     public static int bitSet(int n , int i){
       return (n | (1<<i));
    }

    public static void main(String[] args) {
        int n = 9;
        int i=2;

        System.out.println(bitSet(n, i));
    }
}
