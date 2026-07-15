package applications_real_time_probems;

import java.util.Arrays;

public class aggressiveCows {
    public static void main(String[] args) {
        int[] arr={1, 5, 17};
        System.out.println(minOfMaxUsingBinerySearch(arr,2));
    }

    private static int minOfMAx(int[] arr, int k) {
        Arrays.sort(arr);
        for (int i = 1; i <=(arr[arr.length-1]-arr[0])+1 ; i++) {
            if(canPlaceCows(arr,i,k)){
                continue;
            }
            else{
                return i-1;
            }
        }
        return -1;
    }

    private static int minOfMaxUsingBinerySearch(int[] arr,int k){
        Arrays.sort(arr);
        int start=0;
        int end=arr[arr.length-1]-arr[0];
        while (start<=end){
            int mid=start+(end-start)/2;
            if(canPlaceCows(arr,mid,k)){
                start=mid+1;
            }
            else
                end=mid-1;
        }
        return end;
    }

    private static boolean canPlaceCows(int[] arr, int dist,int maxCows) {
       int cowCount=1 ;
       int lastCow=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]-lastCow>=dist){
                cowCount++;
                lastCow=arr[i];
            }
           if(cowCount==maxCows){
               return true;
           }
        }
      return false;
    }
}
