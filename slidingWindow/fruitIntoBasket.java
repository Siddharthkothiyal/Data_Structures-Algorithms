package slidingWindow;

import java.util.HashMap;

public class fruitIntoBasket {
    public static int totalFruit(int[] fruits) {

        int l = 0;
        int maxlen = 0;
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < fruits.length; r++) {
            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while (map.size() > 2) {
                map.put(fruits[l], map.getOrDefault(fruits[l], 0) - 1);
                if (map.get(fruits[l]) == 0) {
                    map.remove(fruits[l]);
                }
                
                l++;

            }
            maxlen = Math.max(maxlen, r - l + 1);
        }
        return maxlen;
    }
public static void main(String[] args) {
    int [] fruits=  {1,1,1,2,2,3,3,3,3,2,2,1,1,4,4,4,4,4,4,1,1,2,2,2,3,3,3};
    System.out.println(totalFruit(fruits));
}
}
