package Hashmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class closeString {
    public boolean closeStrings(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        if (n != m)
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        // count frequency for word1
        for (int i = 0; i < n; i++) {
            char ch = word1.charAt(i);
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        // count frequency for word2
        for (int i = 0; i < m; i++) {
            char ch = word2.charAt(i);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);
        }

        // check same characters
        if (!map1.keySet().equals(map2.keySet())) {
            return false;
        }

        // compare frequency values
        ArrayList<Integer> list1 = new ArrayList<>(map1.values());
        ArrayList<Integer> list2 = new ArrayList<>(map2.values());

        Collections.sort(list1);
        Collections.sort(list2);

        return list1.equals(list2);
    }


    public static void main(String[] args) {

    }
}
