package slidingWindow;

public class characterReplacement {
    public static int characterreplacement(String s, int k) {
        int l = 0;
        int r = 0;
        int maxlen = 0;
        int maxfreq = 0;
        int[] freq = new int[26];
        while (r < s.length()) {
            freq[s.charAt(r) - 'A']++;
            maxfreq = Math.max(freq[s.charAt(r) - 'A'], maxfreq);

            if (((r - l) + 1) - maxfreq > k) {

                freq[s.charAt(l) - 'A']--;
                l = l + 1;

            }

            if (((r - l) + 1) - maxfreq <= k) {
                maxlen = Math.max(maxlen, r - l + 1);
            }

            r++;

        }

        return maxlen;
    }

    public static void main(String[] args) {

        String s ="AABABBA";
        int k=2;
        int ans= characterreplacement(s, k);
        System.out.println(ans);

    }
}
