package Problems_Topic_Wise.Recursion_pattern_sorting;

import java.util.Arrays;

public class mergeSort {
   public static void main(String[] args) {
	   int[] arr= {5,4,6,36,6,3,11};
//	   System.out.println(arr.length);
	   inPlaceMergeSortRecursion(arr,0,arr.length);
	   System.out.println(Arrays.toString(arr));
   }
 static int[] mergeSortRecursion(int[] arr) {
   if(arr.length==1) {
	   return arr;
   }
   int mid=arr.length/2;
   int[] left=mergeSortRecursion(Arrays.copyOfRange(arr, 0, mid));
   int[] right=mergeSortRecursion(Arrays.copyOfRange(arr, mid, arr.length));
   return merge(left,right);
}

static int[] merge(int[] first, int[] second) {
	int[] mix=new int[first.length+second.length];
	int i=0;
	int j=0;
    int k=0;
	while(i<first.length && j<second.length) {
		if(first[i]>second[j]) {
			mix[k]=second[j];
			j++;
		}
		else {
			mix[k]=first[i];
			i++;
		}
		k++;
	}
	while(i<first.length) {
		mix[k]=first[i];
		i++;
		k++;
	}
	while(j<second.length) {
		mix[k]=second[j];
		j++;
		k++;
	}
	return mix;
}
static void inPlaceMergeSortRecursion(int[] arr,int start,int end) {
	if(end-start==1) {
		   return ;
	   }
	   int mid=(start+end)/2;
	   inPlaceMergeSortRecursion(arr,start,mid);
	   inPlaceMergeSortRecursion(arr,mid,end);
	    mergeInplace(arr,start,mid,end);
}
 static void mergeInplace(int[] arr, int start, int mid, int end) {
	 int[] mix=new int[end-start];
		int i=start;
		int j=mid;
	    int k=0;
		while(i<mid && j<end) {
			if(arr[i]>arr[j]) {
				mix[k]=arr[j];
				j++;
			}
			else {
				mix[k]=arr[i];
				i++;
			}
			k++;
		}
		while(i<mid) {
			mix[k]=arr[i];
			i++;
			k++;
		}
		while(j<end) {
			mix[k]=arr[j];
			j++;
			k++;
		}
		for(int l=0;l<mix .length;l++) {
			arr[start+l]=mix[l];
		}
//		System.out.println(Arrays.toString(arr));
}
}
