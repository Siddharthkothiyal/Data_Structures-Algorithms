package Hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class findDiff {
     public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {

        HashMap<Integer, Integer> map= new HashMap<>();

       List<List<Integer>> ans = new ArrayList<>();

       for (int i = 0; i < nums1.length; i++) {

        if(map.containsKey(nums1[i])){
            map.put(nums1[i] , map.getOrDefault(nums1[i], 1)+1);
        }
       }
        for (int i = 0; i < nums2.length; i++) {
        if(map.containsKey(nums2[i])){
            map.put(nums2[i] , map.getOrDefault(nums2[i],0 )+1);
        }
        
       }

       

        
    }
}
