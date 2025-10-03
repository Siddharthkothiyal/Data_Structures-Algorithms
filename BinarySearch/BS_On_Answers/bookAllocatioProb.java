package BinarySearch.BS_On_Answers;

public class bookAllocatioProb {

    public static int pagesAllot(int[] arr, int k, int pages) {
        int count = 1;
        int pagesPerStudent = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + pagesPerStudent <= pages) {
                pagesPerStudent += arr[i];
            } else {
                count++;
                pagesPerStudent = arr[i];
            }
        }
        return count;
    }

    public static int findPages(int[] arr, int k) {
         int sum=0;
        int maxi=0;
       for(int i=0 ; i<arr.length ; i++){
           maxi= Math.max(arr[i] , maxi);
           sum += arr[i];
       }
        int start=maxi;
        int end =sum;
        if (k > arr.length)
            return -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (pagesAllot(arr, k, mid) > k) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;

    }

    public static void main(String[] args) {

        int nums[] = { 12, 34, 67, 90 };
        int k = 2;

        System.out.println(findPages(nums, k));
    }
}
