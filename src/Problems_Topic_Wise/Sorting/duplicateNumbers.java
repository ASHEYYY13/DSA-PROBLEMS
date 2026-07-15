package Sorting;

public class duplicateNumbers {

	public static void main(String[] args) {
		int[] arr = {1,3,4,1,2};
	System.out.println(findDuplicateNumbers(arr));

	}

 static int findDuplicateNumbers(int[] nums) {
		int i=0;
		while(i<nums.length) {
			if(nums[i]!=i+1) {
				int correct=nums[i]-1;
				if( nums[i]!=nums[correct]) {
					swap(i,correct,nums);
				}
				else {
					return nums[i];
				}
			}
			else {
				i++;
			}
		}
		return -1;
	
	}
 static void swap(int first,int second,int[] arr) {
	 int temp =arr[first];
	 arr[first]=arr[second];
	 arr[second]=temp;
 }
}
