package Sorting;

import java.util.Arrays;

public class cyclic {
    public static void main(String[] args) {
    	int[] arr= {2,3,1};
    	System.out.println(Arrays.toString(cyclicSort(arr)));
    }
    
    static int[] cyclicSort(int[] nums) {
        int i =0;
        while(i<nums.length) {
        	int correct=nums[i]-1;
        	if(nums[i]!=nums[correct]) {
        		sort(nums,i,correct);
        	}
        	else {
        		i++;
        	}
        }
        return nums;
    }

	static void sort(int[] arr, int first,int second) {
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
		
	}
}
