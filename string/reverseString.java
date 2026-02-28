public class reverseString {

     public static String reverseWords(String s) {

       String str[]= s.trim().split("\\s+");


       String newString= "";

       for (int i = str.length-1; i>=1; i--) {
        newString+= str[i]+" "; 
       }


       return newString+ str[0];
        
    }

    public static void main(String[] args) {
        String s= "the sky is blue";

        System.out.println(reverseWords(s));
    }
    
}
