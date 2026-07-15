package Problems_Topic_Wise.binear_prob;

public class celing {
  public static void main(String[] args) {
	  int[] arr = {2,5,8,9,11,14,17,19,24};
	  int target = 7;
	  System.out.println(ceilingelement(arr,target));
  }
  //ceiling of the number means smallest element greater than or equal to target
  static int ceilingelement(int[] arr,int target) {
	  int s = 0;
	  int e = arr.length-1;
	  if(target>arr[arr.length-1]) {
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
			  return arr[mid];
		  }
	  }
	  return arr[s];
  }
}
