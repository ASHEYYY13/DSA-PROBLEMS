package Problems_Topic_Wise.binear_prob;

public class searchinmountain {
	public static void main(String[]args) {
	 int[] arr = {1,2,5,6,4,3,2};
	 int target =3;
	   int start =0;
	   int end =arr.length-1;
	   int peak=(peakElementInArray(arr,start,end));
//	   System.out.println(peak);
	   int ans = search_first_last(arr,target,start,peak);
	   if(ans==-1) {
		    ans = search_first_last(arr,target,peak,end);
		  
	   }
	   
	   System.out.println( ans);
	  
 }
 
 static int peakElementInArray(int[] arr,int start,int end) {
//	   int start =0;
//	   int end =arr.length-1;
	   
	   while(start<end) {
		   int mid = start + (end-start)/2;
		
		   if(arr[mid]<arr[mid+1]) {
			   start = mid +1;
		   }
		   else {
			   end =mid;
		   }
		  
		
	   }
	   return start;
 }
 

 static int search_first_last(int[] arr, int target,int start,int end) {
	 
	 if(start==0) {
	  while(start<=end) {
		  int mid =start + (end-start)/2;
		  if(target<arr[mid]) {
			 end = mid-1;  
		  }
		  else if(target>arr[mid]) {
			  start = mid+1;
		  }
		  else {
			  return mid;
		  }
	  }
	  return -1;
	  
	 }
	  else {
	  while(start<=end) {
		  int mid =start + (end-start)/2;
		  if(target>arr[mid]) {
			 end = mid-1;  
		  }
		  else if(target<arr[mid]) {
			  start = mid+1;
		  }
		  else {
			  return mid;
		  }
	  }
	  return -1;
	  
	  }
 }
}
