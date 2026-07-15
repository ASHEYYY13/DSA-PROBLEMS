package Problems_Topic_Wise.binear_prob;

import java.util.Arrays;

public class first_last {
	public static void main(String[] args) {
		  int[] arr = {2,4,7,7,7,7,8,8,9,10,10,11,243};
		  int target = 7 ;
		  System.out.println(Arrays.toString(FLO(arr,target)));
	  }
	static int[] FLO (int[] arr,int target) {
		int[] ans = {-1,-1};
		int first=search_first_last(arr,target,true);
		int last=search_first_last(arr,target,false);
		ans[0]=first;
		ans[1]=last;
		return ans;
	}
	 
	  static int search_first_last(int[] arr, int target,boolean firstIndex) {
		  int start =0;
		  int end =arr.length-1;
		  int ans = -1;
		  while(start<=end) {
			  int mid =start + (end-start)/2;
			  
			  if(target<arr[mid]) {
				 end = mid-1;  
			  }
			  else if(target>arr[mid]) {
				  start = mid+1;
			  }
			  else {
				  //here the potential answer will come and and change accordingly
			     ans=mid;
			     if(firstIndex==true) {    
				end = mid-1;
			  }
			     else {
			    	 start = mid+1;
			     }
			  }
		  }
		  return ans;
	  }

	  }
