package binear_prob;

public class target_in_rotated_Array {
   public static void main(String[] args) {
	   int[] arr1 = {5,8,10,10,12,20,25,-1,0,2,3,4};
	   int[] arr = {3,1};
	   System.out.println((pivot_index(arr)));
	   int pivot=(pivot_index(arr));
	   int start=0;
	   int end=arr.length-1;
	   int tar=1;
	   if(arr[pivot]==tar) {
		   System.out.println(pivot);
	   }
//	   else
//	   {
// 	   int ans=(target_finder(arr,0,pivot,tar));
//	     if(ans==-1) 
//	     {
//		   ans=(target_finder(arr,pivot,end,tar)); 
//	      }
//	   System.out.println(ans);
//	   
//   }
	   //we can also do other else statements
	   else if(tar>=arr[0]) {
		 int answ=  target_finder(arr,start,pivot,tar);
		 System.out.println(answ);
	   }
	   else {
		int answ =  target_finder(arr,pivot+1,end,tar);
		 System.out.println(answ);
	   }
	  
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
			   if(arr[start]>arr[start+1]) {
				   return start;
			   }
			   start++;
			   if(arr[end] <arr[end-1]) {
				   return end-1;
			   }
			   end--;
		   }
		   else if(arr[start]<arr[mid] || arr[start]==arr[mid] && arr[mid]>arr[end]) {
			   start=mid+1;
		   }
		   else {
			   end=end-1;
		   }
	   }
	   return -1;
   }
    static int target_finder(int[] arr, int start,int end,int target) {
    	  while(start<=end) {
   		   int mid =start + (end-start)/2;
   		     if(arr[mid]<target) {
   		    	 start=mid+1;
   		     }
   		     else if(arr[mid]>target) {
   		    	 end=mid-1;
   		     }
   		     else {
   		    	 return mid;
   		     }
    	  }
    	  return -1;
    }
}
