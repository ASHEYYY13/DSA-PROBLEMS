package Recursion_pattern_sorting;

import java.util.Arrays;

public class bubble {
  public static void main(String[] args) {
	  int[] arr= {5,4,3,2};
	  System.out.println(Arrays.toString(BubbleRecursion(arr,arr.length-1,0)));
   }
  static int[] BubbleRecursion(int[] arr,int row,int col) {
     if(row==0) {
    	 return arr;
     }
     if(col<row) {
    	 if(arr[col]>arr[col+1]) {
    		 //swap
    		 int temp=arr[col];
    		 arr[col]=arr[col+1];
    		 arr[col+1]=temp;
    	 }
    	 return BubbleRecursion(arr,row,col+1);
     }
     else {
    	 return BubbleRecursion(arr,row-1,0);
     }
  }
}
