package slidingWindow;

import java.util.HashMap;

public abstract class minwindowSubstr {

  public static String minWindow(String s, String t) {
    HashMap<Character, Integer> map = new HashMap<>();
    int sIndex = -1;
    int minLength = Integer.MAX_VALUE;
    int n = s.length();
    int m = t.length();
    int l = 0;
    int r = 0;
    int count = 0;

    for (int i = 0; i < m; i++) {
        map.put(t.charAt(i), map.getOrDefault(t.charAt(i), 0) + 1);
    }

    while (r < n) {
        if (map.containsKey(s.charAt(r))) {
            map.put(s.charAt(r), map.get(s.charAt(r)) - 1);

            if (map.get(s.charAt(r)) >= 0) {
                count++;
            }
        }

        while (count == m) {
         if (r - l + 1 < minLength) {
                minLength = r - l + 1;
                sIndex = l;
            }

            if (map.containsKey(s.charAt(l))) {
                map.put(s.charAt(l), map.get(s.charAt(l)) + 1);

                if (map.get(s.charAt(l)) > 0) {
                    count--;
                }
            }
            l++;
        }

        r++;
    }

    return sIndex == -1 ? "" : s.substring(sIndex, sIndex + minLength);
}

    public static void main(String[] args) {
        String s = "abcdebdde";
        String t = "bde";

        System.out.println(minWindow(s, t));
    }

}
