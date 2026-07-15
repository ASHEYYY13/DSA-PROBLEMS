package BinearySearchProblems;

public class peakElement {
    public static void main(String[] args) {
        int[] arr={-3 ,-5};
        System.out.println(peak(arr));
    }

    private static int peak(int[] arr) {
        int value=Integer.MIN_VALUE;
      if(arr.length==1){
            return 0;
      }

        for (int i = 0; i <arr.length ; i++) {
            if(i==0){
                if(arr[i]>value && arr[i]>arr[i+1]){
                    return i;
                }
            }
            else if (i==arr.length-1) {
                 if(arr[i]>arr[i-1] && arr[i]>value){
                     return i;
                 }
            }
            else {
                if (arr[i] > arr[i - 1] && arr[i] > arr[i + 1]) {
                    return i;
                }
                continue;
            }
        }
        return -1;
    }


    private static int peakBinary(int[] arr) {
        if(arr.length==1){
            return 0;
        }
        if(arr[0]>arr[1]){
            return 0;
        }
        if(arr[arr.length-1]>arr[arr.length-2]){
            return arr.length-1;
        }
        int start=1;
        int end=arr.length-2;
        while (start<=end){
          int mid=start+(end-start)/2;
          if(arr[mid]>arr[mid+1] && arr[mid]>arr[mid-1]){
              return mid;
          }
         else if(arr[mid]>arr[mid-1]){
              start=mid+1;
          }
         else {
             end=mid-1;
            }
        }
        return -1;
    }

}
