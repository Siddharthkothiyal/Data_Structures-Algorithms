public class searchInRotatedSortedArray {
    public static int search(int[] nums, int k) {
     int start=0, end=nums.length-1;
     while(start<=end){ 
int mid=start+(end-start)/2;
         if(nums[mid]==k) return mid;
         if(nums[start]<=nums[mid]){
             if(k>=nums[start] && k<=nums[mid]){
                 end=mid-1;
             }else{
                 start=mid+1;
             }
         }else if(k>=nums[mid] && k<=nums[end]){
             start=mid+1;
         }else{
             end=mid-1;
         }

     }
       return -1;
}

   
    public static void main(String[] args) {
        int []nums = {4, 5, 6, 7, 0, 1, 2};
        int k = 0;
        System.out.println(search(nums, k));
    }

}
