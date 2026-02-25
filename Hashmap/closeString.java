package Hashmap;

import java.util.HashMap;
import java.util.HashSet;

public class closeString {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        HashSet<Character> set = new HashSet<>();

        if (n != m)
            return false;

        for (int i = 0; i < n; i++) {
            set.add(word1.charAt(i));
        }

    }

    public static void main(String[] args) {

    }
}
