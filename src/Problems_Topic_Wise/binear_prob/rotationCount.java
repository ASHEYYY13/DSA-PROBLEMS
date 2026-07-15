package binear_prob;

public class rotationCount {
   public static void main(String[] args) {
	   int[] arr = {1,2,3,4,6,8,9};
	   int pivot=(pivot_index(arr));
	   System.out.println(pivot+1);//this is rotation count in rotated sorted array we need find pivot and add plus 1 thats it
   }
   static int pivot_index(int[] arr) {
     	int start=0;
       int end=arr.length-1;
	   while(start<=end) {
		   int mid =start + (end-start)/2;
		   if(mid<end && arr[mid]>arr[mid+1]) {
			   return mid;
		   }
		   else if(mid>start &&arr[mid]<arr[mid-1]) {
			   return mid-1;
		   }
//		   else if(arr[mid]>arr[start]) {
//			   start=mid+1;
//		   }
//		   else {
//			   end=mid-1;
//		   }
		   //what if there are duplicate elements like {4,5,5,5,6,6,6,2,3,3,4}; this
		   //we can  skip the duplicates 
		   if(arr[start]==arr[mid] && arr[end] ==arr[mid]) {
			   //what if start and end are pivot
//			   if(arr[start]>arr[start+1]) {
//				   return start;
//			   }
			   start++;
//			   if(arr[end] <arr[end-1]) {
//				   return end-1;
//			   }
			   end--;
		   }
		   else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]) {
			   start=mid+1;
		   }
		   else {
			   end=mid-1;
		   }
	   }
	   return -1;
  }
}
