package sorting_Agorithms;

import java.util.Arrays;

public class megreSort {
    public static void main(String[] args) {
        int[] arr={4,1,3,9,7};
        megre(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }

    private static void megre(int[] arr,int start,int end) {
      if(end-start==1){
          return;
      }
      int mid=start+(end-start)/2;
      megre(arr,start,mid);
      megre(arr,mid,end);
      megreboth(arr,start,mid,end+1);


    }

    private static void megreboth(int[] arr, int start, int mid, int end) {
        int[] mix=new int[end-start];
         int i=start;
         int j=mid;
         int k=0;
         while (i<mid && j<end){
              if(arr[i]<arr[j]){
                  mix[k++]=arr[i];
                  i++;
              }
              else {
                  mix[k++]=arr[j];
                  j++;
              }
         }

         while (i<mid){
             mix[k++]=arr[i];
             i++;
         }

        while (j<end){
            mix[k++]=arr[j];
            j++;
        }

        for (int l = 0; l <mix.length ; l++) {
            arr[start+l]=mix[l];
        }
    }
}
