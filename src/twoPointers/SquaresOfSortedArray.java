package Problems_Topic_Wise.twoPointers;

import java.util.Arrays;

public class SquaresOfSortedArray {
     static int[] SquaresOfSortedArrayBrute(int[] arr){
        for (int i = 0; i < arr.length ; i++) {
            arr[i]=arr[i]*arr[i];
        }
         Arrays.sort(arr);
        return arr;
    }

    static int[] SquaresOfSortedArrayOptimal(int[] arr){

      int[] result=new int[arr.length];

      int left=0;
      int right= arr.length-1;
      int i=0;
      while (left<=right){
          if(Math.abs(arr[left])> Math.abs(arr[right])){
              result[i]=arr[left]*arr[left];
              i++;
              left++;
          }
          else {
              result[i]=arr[right]*arr[right];
              i++;
              right--;
          }
      }

      return reverseArray(result);
    }

    private static int[] reverseArray(int[] result) {
       int left=0;
       int right= result.length-1;
       while (left<right){
           int a=result[left];
           result[left]=result[right];
           result[right]=a;
           left++;
           right--;
       }

       return result;
    }
}
