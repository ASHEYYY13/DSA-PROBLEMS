package Problems_Topic_Wise.binear_prob;

public class search_index {
  public static void main(String[] args) {
	  int[] arr = {2,4,7,8,13,17,21,35,56};
	  int target = 7 ;
	  System.out.println(search_index(arr,target));
  }
  //here we are return target's index in the array else return -1 
  static int search_index(int[] arr, int target) {
	  int start =0;
	  int end =arr.length-1;
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
}
