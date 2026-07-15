package Sorting;

public class firstMissingPositive {
   public static void main(String[] args) {
	   int[]arr= {8,9,10,11,12};
	   System.out.println(FindMissingPositive(arr));
   }

	static int FindMissingPositive(int[] nums) {
		   int i =0;
	        while(i<nums.length) {
	        	int correct=nums[i]-1;
	        	if( nums[i]>0 && nums[i]<=nums.length && nums[i] != nums[correct] ) {
	        			 swap(nums,i,correct);
	        	}
	        	else {
	        		i++;
	        	}
	        }
	    	
	   return findNumber(nums);
	}
	
	static int findNumber(int[] arr) {
		
		for(int index=0;index<arr.length;index++) {
			if(arr[index]!=index+1) {
				return index+1;
			}
			
		}
		return arr.length+1;
	}


	static void swap(int[] arr, int first,int second) {
		int temp=arr[first];
		arr[first]=arr[second];
		arr[second]=temp;
		
	}
}
