package matrixProoblems;

import java.util.Arrays;

public class peakInMatrix {
    public static void main(String[] args) {
        int[][] matrix={
                {10,50,40,30,20},
                {1,500,2,3,4}
        };
//        System.out.println(matrix[0].length);
        System.out.println(Arrays.toString(peakIn2D(matrix)));
    }
    static int[] peakIn2D(int[][] mat){
     int start=0;
     int end= mat[0].length-1;
   while (start<=end){
       int mid=start+(end-start)/2;
       int rowMax=max(mat,mid);
       int left=mid-1>=0?mat[rowMax][mid-1]:-1;
       int right=mid+1<=end?mat[rowMax][mid+1]:-1;
       if(mat[rowMax][mid]>left && mat[rowMax][mid]>right){
           return new int[] {rowMax,mid};
       } else if (mat[rowMax][mid] <left) {
           end=mid-1;
       }
       else {
           start=mid+1;
       }
   }
   return new int[] {-1,-1};
    }

    private static int max(int[][] mat, int col) {
        int maxIndex=-1;
        int maxValue=-1;
        for (int i = 0; i <mat.length ; i++) {
            if(mat[i][col]>maxValue){
                maxIndex=i;
                maxValue=mat[i][col];
            }
        }
        return maxIndex;
    }
}
