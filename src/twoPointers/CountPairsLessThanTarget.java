package twoPointers;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CountPairsLessThanTarget {
    public static int countPairs(int[] nums, int target) {

        int pairs=0;
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                if(nums[i]+nums[j]<target){
                   pairs++;
                }
            }
        }
        return pairs;
    }

    public static int countPairsOptimal(int[] nums, int target) {

       Arrays.sort(nums);
        int pairs=0;
        int left=0;
        int right=nums.length-1;
        while (left<right){
            int sum=nums[right]+nums[left];
            if(sum<target){
                pairs+=right-left;
                left++;
            }
            else {
                right--;
            }
        }
        return pairs;
    }


    public static int countPairsOptimal(List<Integer> nums, int target) {

        Collections.sort(nums); // or nums.sort(null);

        int pairs = 0;
        int left = 0;
        int right = nums.size() - 1;

        while (left < right) {
            int sum = nums.get(left) + nums.get(right);

            if (sum < target) {
                pairs += right - left;
                left++;
            } else {
                right--;
            }
        }

        return pairs;
    }

}
