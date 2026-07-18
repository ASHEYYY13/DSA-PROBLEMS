package twoPointers;

import java.util.Arrays;

public class SumPairdWithDiffK {
    public static int sumDiffPairs(int[] arr, int k) {

        int sum=0;
        Arrays.sort(arr);
        for (int i = arr.length-1; i >0 ; i--) {
            if(arr[i]-arr[i-1]<k){
               sum+=arr[i]+arr[i-1];
               i--;
            }
        }

        return sum;

    }
}
