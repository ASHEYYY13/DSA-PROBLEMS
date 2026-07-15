package ArrayProblems;

import java.util.Arrays;

public class moveZeroToEnd {
    public static void main(String[] args) {
        int[] arr={1,2,0,4,3,0,5,0};
        pushZerosToEndGFG(arr);
        System.out.println(Arrays.toString(arr));;
    }
    static void pushZerosToEnd(int[] arr) {
        int start=0;
        int end=arr.length-1;
        while(start<=end){
            while(arr[start]!=0){
                start++;
            }
            while((arr[end]==0)){
                end--;
            }
            if(start<=end){
                swap(arr,start,end);
                start++;
                end--;
            }
        }
    }


    static void pushZerosToEndGFG(int[] arr) {
      int count=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]!=0){
                swap(arr,i,count);
                count++;
            }
        }
    }

    static void swap(int[] arr,int first,int second ){
        int temp=arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }
}
