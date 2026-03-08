package stack;

import java.util.Stack;

public class starRemoval {
     public static String removeStars(String s) {
        Stack <Character> st= new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isLetter(s.charAt(i)) ) {
                st.add(s.charAt(i)); 
            }else if(s.charAt(i)== '*'){
                st.pop();
            }
            
        }

        StringBuilder ans = new StringBuilder();

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }

        return ans.reverse().toString();
    }

    public static void main(String[] args) {

        String s ="leet**cod*e";



        
        System.out.println(removeStars(s));
    }
    
}
