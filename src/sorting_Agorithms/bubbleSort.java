package sorting_Agorithms;

import java.util.Arrays;

public class bubbleSort {
    public static void main(String[] args) {
        int[] arr={5,7,3,2,7};
        sortInBubble(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sortInBubble(int[] arr) {
        for (int i = 0; i < arr.length-1 ; i++) {
            for (int j = 0; j < arr.length-i-1; j++) {
                if (arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
    }
    static void swap(int[] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
}
