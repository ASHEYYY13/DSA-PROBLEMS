
package Problems_Topic_Wise.Sorting;

import java.util.Arrays;

public class bubble {
  public static void main(String[] args) {
	  int arr[] = {3,1,5,4,2};
	  System.out.println(Arrays.toString(bubbleSort(arr)));
  }
  
  static int[] bubbleSort(int[] arr) {
	  boolean swapped;// we are using this identify where the arr is swapped or not coz
	  for(int i=0;i<arr.length;i++) {      //if didn't swap means we don't have to run the loop coz its already sorted 
		  swapped =false;
		  for(int j=1;j<arr.length-i;j++) {
			  if(arr[j]<arr[j-1]) {
				  //swap them
				  int temp=arr[j];
				  arr[j]=arr[j-1];
				  arr[j-1]=temp;
				  swapped =true;
			  }
		  }
		  if(swapped==false) {//we can also do if(!swapped) it means swapped is false
			  break;
		  }
	  }
	  return arr;
  }
}
