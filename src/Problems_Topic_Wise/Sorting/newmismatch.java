package Sorting;

import java.util.Arrays;

public class newmismatch {
    public static void main(String[] args) {
   	 int[] arr= {2,1,4,2,6,5};
   	 System.out.println(Arrays.toString(setMismatch(arr)));
    }

 static int[] setMismatch(int[] nums) {
	   int i =0;
       while(i<nums.length) {
       	int correct=nums[i]-1;
       	if( nums[i] != nums[correct] ) {
       			 swap(nums,i,correct);
       	}
       	else {
       		i++;
       	}
       }
   	
  return findNumber(nums);
}

static int[] findNumber(int[] arr) {
	
	for(int index=0;index<arr.length;index++) {
		if(arr[index]!=index+1) {
			return new int[] {arr[index],index+1};
		}
	}
	return new int[] {-1,-1};
}


static void swap(int[] arr, int first,int second) {
	int temp=arr[first];
	arr[first]=arr[second];
	arr[second]=temp;
	
}
	}
