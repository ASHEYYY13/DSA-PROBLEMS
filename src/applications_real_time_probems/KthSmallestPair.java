package applications_real_time_probems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class KthSmallestPair {
    public static void main(String[] args) {
        int[] arr={62,100,4};
        System.out.println(smallestBinarySearch(arr,2));
    }

    private static int smallest(int[] arr, int k) {
        ArrayList<Integer> list=new ArrayList<>();
     int count=0;
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j <arr.length ; j++) {
                list.add(Math.abs(arr[i]-arr[j]));
            }
        }
        Collections.sort(list);
        return list.get(k-1);
    }
    private static int smallestBinarySearch(int[] arr, int k) {
        Arrays.sort(arr);
        int low=0;
        int high=Math.abs(arr[arr.length-1]-arr[0]);
        while (low<=high){
            int mid=low+(high-low)/2;
            if(midthSmallest(arr,mid)>=k){
                high=mid-1;
            }
            else {
                low=mid+1;
            }
        }
        return low;
    }

    private static int midthSmallest(int[] arr, int mid) {
        int count=0;
        int j=0;

        for (int i = 0; i <arr.length ; i++) {
           while (j<arr.length  && (arr[j]-arr[i]<=mid)){
               j++;
           }
           count=count+(j-i-1);
        }
        return count;
    }
}
