package Problems_Topic_Wise.twoPointers;

import java.util.*;

public class ThreeSum {
    public static List<List<Integer>> threeSumBrute(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length;  i++) {
            for (int j = i+1; j < nums.length ; j++) {
                for (int k = j+1; k < nums.length ; k++) {
                    if(nums[i]+nums[j]+nums[k]==0){
                        List<Integer> list = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(list);
                        set.add(list);
                    }
                }
            }
        }
        result.addAll(set);
        return result;
    }


    public static List<List<Integer>> threeSumBetter(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length;  i++) {
            HashSet<Integer> thirdNumberSet=new HashSet<>();
            for (int j = i+1; j < nums.length ; j++) {
               int third=-(nums[i]+nums[j]);
               if(thirdNumberSet.contains(third)){
                   List<Integer> list = Arrays.asList(nums[i], nums[j], third);
                   Collections.sort(list);
                   set.add(list);
               }
                   thirdNumberSet.add(nums[j]);
            }
        }
        result.addAll(set);
        return result;
    }

    public static List<List<Integer>> threeSumOptimal(int[] nums){
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < nums.length;  i++) {
         if(i>0 && nums[i]==nums[i-1]) continue;
         int j=i+1;
         int k= nums.length-1;
         while (j<k){
             int sum=nums[i]+nums[j]+nums[k];
             if(sum>0){
                 k--;
             } else if (sum<0) {
                 j++;
             }
             else {
                 result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                 j++;
                 k--;
                 while (j<k && nums[j]==nums[j-1]) j++;
                 while (j<k && nums[k]==nums[k+1]) k--;
             }
         }
        }
        return result;
    }
}
