package binear_prob;

public class SplitArray {
  public static void main(String[] args) {
	  int[] nums = {7,2,5,8,10,23,12,1};
	  int m=2;
	  System.out.println(LargestSumInArray(nums,m));
  }
  static int LargestSumInArray(int[] arr,int m) {
	  int start=0;
	  int end=0;
	  for(int i=0;i<arr.length;i++) {
		  start=Math.max(start, arr[i]);//here we are getting our start which is minimum answer or we can largest number in array
		  end=end+arr[i]; //here we are getting largest answer which is sum of all the numbers in the array
	  }  //so the answer lies between start and end so we use binary search;
	  
	  while(start<end) {
		  int sum=0;
		  int pieces=1;
		  int mid =start +(end-start)/2;//mid is an potential number;
		  for(int i=0;i<arr.length;i++) {
			  if(sum+arr[i]>mid) {
			 // if the array of exceeds the mid we need create new array
				  sum=arr[i];
				  pieces++;
			  }
			  else {
				  sum = sum+arr[i];
			  }
		  }
		  if(pieces>m) {
			  start=mid+1;
		  }
		  else {
			 end=mid;
		  }
	  }
	  return end;
  }
}
