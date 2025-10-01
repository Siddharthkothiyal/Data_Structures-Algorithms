public class Search_Insert_Position {
     public static int searchInsert(int[] nums, int target) {
        int start = 1;
        int end = nums.length-1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (nums[mid]== target) {
               return mid;
            } else if(nums[mid]< target){
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        return -1;
    }

     public static void main(String[] args) {
        int[] nums = { 12,24,66,83, 90 };
        int x =90;

        System.out.println(searchInsert(nums, x));

  
    }
}
