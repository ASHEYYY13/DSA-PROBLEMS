package ArrayProblems;

import java.util.Arrays;

public class rototeRight {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5};
        rotateArr(arr,2);
        System.out.println(Arrays.toString(arr));
    }
    static void rotateArr(int[] arr, int d) {
        int n=arr.length;
        d=d%n;
        reverse(arr,0,d-1);
        reverse(arr,d,arr.length-1);
        reverse(arr,0,arr.length-1);
    }

    static void reverse(int[] arr,int st,int en){
        int start=st;
        int end=en;
        while(start<=end){
            swap(arr,start,end);
            start++;
            end--;
        }
    }

    static void swap(int[] arr,int first,int second){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
