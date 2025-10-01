public class occuranceofNo {
    public static int firstOccur(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int first = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] >= target) {
                end = mid - 1;
                first = mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return first;
    }

    public static int secondOccur(int arr[], int target) {
        int start = 0;
        int end = arr.length - 1;
        int second = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] <= target) {
                start = mid + 1;
                second = mid;
            } else if (arr[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return second;
    }

    public static int countOccurrences(int[] arr, int target) {
        int ans[] = new int[2];
        ans[0] = firstOccur(arr, target);
        ans[1] = secondOccur(arr, target);
        return ans[1] - ans[0] + 1;
    }

    public static void main(String[] args) {
        int[] arr = { 0,0,0,0,1,1,1,1,1,1,2,2,3,4,5,5,5,5,5,6,7,8,9 };
        int x = 5;
        System.out.println(countOccurrences(arr, x));
    }
}
