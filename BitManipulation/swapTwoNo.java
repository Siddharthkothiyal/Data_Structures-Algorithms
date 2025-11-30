package BitManipulation;

public class swapTwoNo {

    public static void swap(int a, int b) {

        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

    System.out.println("after swap value of a is " + a);
    System.out.println("after swap value of b is " + b);

    }

    public static void main(String[] args) {
        int a =3;
        int b = 4;

     swap(a, b);;


    }

}
