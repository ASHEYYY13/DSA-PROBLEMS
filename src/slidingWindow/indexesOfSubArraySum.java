package slidingWindow;

import java.util.ArrayList;

public class indexesOfSubArraySum {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(findIndexes(arr,15));
    }

    private static ArrayList<Integer> findIndexes(int[] arr,int target) {
        ArrayList<Integer> ans=new ArrayList<>();
        int start=0;
        int sum=0;
//        int end=0;
        for (int i = 0; i <arr.length ; i++) {
            sum+=arr[i];
            if(sum>target){

                while (sum>target && start<i) {
                    sum -= arr[start];
                    start++;
                }
            }
            if(sum==target){
                ans.add(start+1);
                ans.add(i+1);
                return ans;
            }
        }

        ans.add(-1);
        return ans;
    }
}
