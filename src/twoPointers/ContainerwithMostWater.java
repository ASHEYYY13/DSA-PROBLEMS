package twoPointers;

import java.util.Arrays;

public class ContainerwithMostWater {
    public static int ContainerwithMostWaterBrute(int[] nums){
        int result=0;
        for (int i = 0; i < nums.length ; i++) {
            for (int j = i+1; j < nums.length ; j++) {
                int amount=Math.min(nums[i],nums[j])* (j-i);

                result=Math.max(amount,result);
            }
        }

        return result;
    }


    public static int ContainerwithMostWaterOpyimal(int[] nums){
        int result=0;
       int left=0;
       int right=nums.length-1;
       while (left<right){
           int amount=Math.min(nums[left],nums[right])* (right-left);

           result=Math.max(amount,result);
           if(nums[left]<nums[right]){
               left++;
           }
           else {
               right--;
           }
       }

        return result;
    }
}
