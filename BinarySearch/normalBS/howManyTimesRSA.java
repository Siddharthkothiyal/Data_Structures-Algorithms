import java.util.ArrayList;

public class howManyTimesRSA {
    public static int findKRotation(int[] arr) {
        int start = 0, end = arr.length-1 ;
        int ans = Integer.MAX_VALUE;
        int index = -1;
        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[start] <= arr[end]) {
                if (arr[start] < ans) {
                    index = start;
                    ans = arr[start];
                }
                break;
            }

            if (arr[start] <= arr[mid]) {

                if (arr[start] < ans) {
                    index = start;
                    ans = arr[start];
                }

                start = mid + 1;
            } else {
                if (arr[mid] < ans) {
                    index = mid;
                    ans = arr[mid];
                }

                end = mid - 1;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] arr = { 7,8,9,1,2,3,4,5,6 };
        System.out.println(findKRotation(arr));
    }
}
