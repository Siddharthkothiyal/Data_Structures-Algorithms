import java.util.ArrayList;

public class howManyTimesRSA {

    public static int bs(ArrayList<Integer> arr) {

        int start = 0;
        int end = arr.size() - 1;
        int ans = Integer.MAX_VALUE;

        while (start < end) {
              int mid = (start + end) / 2;

              if(arr.get(start) <= arr.get(end)){
                ans = Math.min(ans, start);
                break;
              }

            //if left part is sorted:
            if (arr.get(start) <= arr.get(mid)) {
                // keep the minimum:
                ans = Math.min(ans, arr.get(start));

                // Eliminate left half:
                start = mid + 1;

            } else { //if right part is sorted:

                // keep the minimum:
                ans = Math.min(ans, arr.get(mid));

                // Eliminate right half:
                end = mid - 1;
            }
        }
        return ans;
    }

    public int findKRotation(ArrayList<Integer> nums) {
        return bs(nums) ;
    }

    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(15);
        arr.add(1);
        arr.add(2);
        arr.add(3);
        arr.add(6);
        arr.add(12);

        System.out.println(bs(arr));

    }
}
