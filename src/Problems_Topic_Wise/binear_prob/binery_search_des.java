package binear_prob;

public class binery_search_des {
  public static void main(String[] args) {
	  int[] arr  = {109,98,76,64,62,45,23,10,7,-1,-8};
	  int target = -1;
	  System.out.println(search_index(arr,target));
  }
  static int search_index(int[] arr, int target) {
	  int start =0;
	  int end =arr.length-1;
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
