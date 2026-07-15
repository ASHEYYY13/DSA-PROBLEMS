package Problems_Topic_Wise.Sorting;

public class mismatch {
 public static void main(String[] args) {
	 int[] arr= {1,2,2,4};
	 System.out.println(setMismatch(arr));
	 
 }
 static int[] setMismatch(int[] nums) {
	 int i=0;
	 while(i<nums.length) {
		 if(nums[i]!=i+1) {
		 int correct =nums[i]-1;
		 if(nums[i]!=correct) {
			 swap(nums,i,correct);
		 }
		 else {
			 return new int[] {nums[i],i};
		 }
		 }
		 else {
			 i++;
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
