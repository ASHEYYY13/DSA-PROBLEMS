package twoPointers;

public class MoveZeros {
    public static void moveZeroesBrute(int[] nums) {

        int[] res=new int[nums.length];
        int zeros=0;
        int idx=0;
        for (int i = 0; i < nums.length ; i++) {
            if(nums[i]!=0){
                res[idx]=nums[i];
                idx++;
            }
            else {
                zeros++;
            }
        }

        for (int i = 0; i <res.length ; i++) {
            nums[i]=res[i];
        }
        for (int i =res.length-zeros; i <nums.length ; i++) {
            nums[i]=0;
        }
    }

    public static void moveZeroesOptimal(int[] nums) {

        int j=-1;
        for (int i = 0; i <nums.length ; i++) {
            if(nums[i]==0){
                j=i;
                break;
            }
        }
        if(j==-1){
            return;
        }

        for (int i = j+1; i <nums.length ; i++) {
            if(nums[i]!=0){
                swap(nums,i,j);

                j++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

}
