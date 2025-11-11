package slidingWindow;



public class substrABC {
    public static int numberOfSubstrings(String s) {

        int[] freq = new int[3];
        int left = 0;
        int countSubStr = 0;

        for (int right = 0; right < s.length(); right++) {

            freq[s.charAt(right) - 'a']++;

            while (freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                countSubStr += s.length() - right;

                freq[s.charAt(left) - 'a']--;
                left++;
            }

        }

        return countSubStr;

    }

    public static void main(String[] args) {
        String s = "abcabc";
int ans = numberOfSubstrings(s);
System.out.println(ans);
    }
}
