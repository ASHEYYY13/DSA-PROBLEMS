package Recursion_array_Question;

public class findInRotatedSortedArray {
  public static void main(String[] args) {
	  int[] arr= {5,6,7,9,1,2,4};
	  int start=0;
	  int end=arr.length-1;
	  System.out.println(find(arr,6,start,end));
  }
  static int find(int[] arr,int target,int start,int end) {
	  int mid=start + (end-start)/2;
	  if(target==arr[mid]) {
		  return mid;
	  }
	 if(arr[start]<=arr[mid]) {
		 if(target>=arr[start] && target<=arr[mid] ){
			 return find(arr,target,start,mid-1);
		 }
		 else {
			 return find(arr,target,mid+1,end);
		 }
	 }
	 if(target>=arr[mid]&&target<arr[end]) {
		 return find(arr,target,start,mid-1);
	 }
	 
	 return find(arr,target,start,mid-1);
  }
}
