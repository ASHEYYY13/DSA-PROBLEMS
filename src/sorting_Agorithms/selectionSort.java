package sorting_Agorithms;

import java.util.Arrays;

public class selectionSort {
    public static void main(String[] args) {
        int[] arr={5,4,3,2,1};
        selection(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void selection(int[] arr) {
        for (int i = 0; i < arr.length ; i++) {
            int lastElement=arr.length-1-i;
            int maxIndex=getMaxElement(arr,0,lastElement);
            swap(arr,maxIndex,lastElement);
        }

    }

    private static int getMaxElement(int[] arr, int start, int lastElement) {
      int  maxIndex=start;
        for (int j = 1; j <=lastElement ; j++) {
            if(arr[maxIndex]<arr[j]){
//                max=arr[j];
                maxIndex=j;
            }
        }
        return maxIndex;
    }

    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
