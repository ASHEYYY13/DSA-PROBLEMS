package sorting_Agorithms;

import java.util.Arrays;

public class quickSort {
    public static void main(String[] args) {
  int[] arr={4, 1, 3, 9, 7};
  quick(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    static void quick(int[] arr,int low,int high){
        while (low>=high){
            return;
        }
        int start=low;
        int end=high;
        int mid=start+(end-start)/2;
        int pivot=arr[mid];

        while (start<=end){
            while (arr[start]<pivot){
                start++;
            }
            while (arr[end]>pivot){
                end--;
            }

            if(start<=end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }
        quick(arr,low,end);
        quick(arr,start,high);
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
