package twoPointers;

public class SortColors {
    public static void sortColors(int[] nums){
       int ones=0;
       int twos=0;
       int zeros=0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]==0){
                zeros++;
            }
            else if(nums[i]==1){
                ones++;
            }
            else {
                twos++;
            }
        }
        int i=0;
        while (zeros>0) {nums[i]=0; zeros--; i++;}
        while (ones>0) {nums[i]=1; ones--; i++;}
        while (twos>0) {nums[i]=2; twos--; i++;}
    }
}
