package Recursion_pattern_sorting;

import java.util.Arrays;

public class selection {
   public static void main(String[] args) {
		  int[] arr= {5,4,3,2};
		  System.out.println(Arrays.toString(selectionRecursion(arr,arr.length,0,0)));
   }

static int[] selectionRecursion(int[] arr,int row,int col,int max) {
	if(row==0) {
		return arr;
	}
	if(col<row) {
		if(arr[col]>arr[max]) {
			return selectionRecursion(arr,row,col+1,col);
		}
		return selectionRecursion(arr,row,col+1,max);
	}
		
		else {
			int temp=arr[max];
			arr[max]=arr[row-1];
			arr[row-1]=temp;
			return selectionRecursion(arr,row-1,0,0);
		}
		
	
}
}
