package binear_prob;

public class floor {
	 public static void main(String[] args) {
		  int[] arr = {2,5,8,9,11,14,17,19,24};
		  int target = 3;
		  System.out.println(floorelement(arr,target));
	  }
	 
	 // floor element means greatest element smaller thanor equal to target
	  static int floorelement(int[] arr,int target) {
		  int s = 0;
		  int e = arr.length-1;
		  if(target<arr[0]) {
			  return -1;
		  }
		  while(s<=e)
		  {
			  int mid = s+ (e-s)/2;
			  if(target<arr[mid]) {
				  e=mid-1;
			  }
			  else if(target>arr[mid]) {
				  s=mid+1;
			  }
			  else {
				  return mid;
			  }
		  }
		  return e;
	  }
}
