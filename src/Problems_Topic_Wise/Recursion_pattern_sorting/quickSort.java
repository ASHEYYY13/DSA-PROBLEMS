  package Problems_Topic_Wise.Recursion_pattern_sorting;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
         int[] arr= {5,3,1,47,43};
         quick(arr,0,arr.length-1);
         System.out.println(Arrays.toString(arr));
    }
    static void quick(int[] arr,int low,int high) {
    	while(low>=high) {
    		return;
    	}
    	int s=low;
    	int e=high;
    	int mid=s+(e-s)/2;
    	int pivot=arr[mid];
    	
    	while(s<=e) {
    		while(arr[s]<pivot) {
    			s++;
    		}
    		while(arr[e]>pivot) {
    			e--;
    		}
    		
    		if(s<=e) {
    			int temp=arr[s];
    			arr[s]=arr[e];
    			arr[e]=temp;
    			s++;
    			e--;
    		}
    	}
    	quick(arr,low,e);
    	quick(arr,s,high);
    	
    }
}
