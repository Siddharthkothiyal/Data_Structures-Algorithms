
public record lower_Bound() {
    public static int lowerBound(int[] nums, int x) {

        int start = 0;
        int end = nums.length;
        while (start <= end) {

            int mid = (start + end) / 2;
            if (nums[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return start;

    }

    public static void main(String [] args){
        int [] nums= {3,5,8,15,19};
        int x = 9;
        System.out.println(lowerBound(nums, x));
    }
}
