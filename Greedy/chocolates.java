package Greedy;

import java.util.Arrays;

public class chocolates {
     public static int findContentChildren(int[] g, int[] s) {

        Arrays.sort(g);
        Arrays.sort(s);

        int l= 0;  //child
        int r= 0;   //cookie

        while (l< g.length && r< s.length) {

            if( s[r] >= g[l]){
                l++;
                r++;
                
            }else{
            
                r++;
            }
            
        }

        return l;
    }
    
    public static void main(String[] args) {
        int []g = {1,2} ;
        int []s = {1,2,3};

        System.out.println(findContentChildren(g, s));


    }
}
