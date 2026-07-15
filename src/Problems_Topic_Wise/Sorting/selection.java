package Sorting;

import java.util.Arrays;

public class selection {
	public static void main(String[] args) {
      int arr[] = {0,-1,3,-5,3,8,10};
      System.out.println(Arrays.toString(SelectionSort(arr)));
	}   
	static int[] SelectionSort(int[] arr) {
		for(int i=0;i<arr.length;i++) {
			int last =arr.length-i-1;
			int maxIndex = getMaxIndex(arr,0,last);
		  int temp=arr[maxIndex];
		   arr[maxIndex]=arr[last];
		  arr[last]=temp;
		  
		}
		return arr;
	}
	
	static int getMaxIndex(int[] arr,int start,int end) {
		int max=start;
		for(int i=1;i<=end;i++) {
			if(arr[max]<arr[i]) {
				max=i;
			}
		}
		return max;
	}
}
