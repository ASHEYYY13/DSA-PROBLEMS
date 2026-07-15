package twoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumClosest {
    public static int threeSumClosest(int[] nums,int target){
        int closest = nums[0] + nums[1] + nums[2];
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;  i++) {
            if(i>0 && nums[i]==nums[i-1]) continue;
            int j=i+1;
            int k= nums.length-1;
            while (j<k){
                int sum=nums[i]+nums[j]+nums[k];
                if (Math.abs(target - sum) < Math.abs(target - closest)) {
                    closest = sum;
                }

                if (sum == target) {
                    return sum;
                } else if (sum < target) {
                    j++;
                } else {
                    k--;
                }
            }
        }
        return closest;
    }
}
