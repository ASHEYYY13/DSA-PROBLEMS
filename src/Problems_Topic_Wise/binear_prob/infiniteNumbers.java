package Problems_Topic_Wise.binear_prob;

public class infiniteNumbers {
	  public static void main(String[] args) {
		  int[] arr = {3,5,7,9,10,90,100,130,140,160,190};
		  int target = 10 ;
		  System.out.println(search_index(arr,target));
	  }
	
	  static int search_index(int[] arr, int target) {
		  //in normal binary search we will cut the half and then half n,n/2,n/4 like that
		  //here we are doubling the size of the array n*2,n*4 like that
		  int start =0;  //first we start from 0 and end 1 like size of the array is two
		  int end =1;
		  while(start<=end) {
			  if(target<=arr[end]) { // checking if the target weare looking available in this chunk of array
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
			  else {
				  
				  //if not we are doubling the array size like we get a new start which is end +1
//				  int temp = end +1;
//				  end =end +(end-start +1)*2;   we are changing the end and making it bigger than the before chunk
//			       start =temp;
				   start = end +1;
				  end = start*2+1;
			  }
		  }
		  return -1;
	  }
	} 

