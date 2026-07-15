package matrixProoblems;

import java.util.Arrays;

public class minimumNumber {
    public static void main(String[] args) {
       int[][] matrix={
               {1,1,1},
               {1,1,1},
               {0,0,0}
       };
        System.out.println(Arrays.toString(minimumOptimal(matrix,3)));
    }
    static int[] minimum(int[][] mat){
       int rowNum=0;
       int maxCount=0;
        for (int i = 0; i <mat.length ; i++) {
            int count=0;
            for (int j = 0; j <mat[0].length ; j++) {
                if(mat[i][j]==1){
                    count++;
                }
            }
            if(count>maxCount){
                maxCount=count;
                rowNum=i;
            }
        }
        return new int[] {rowNum,maxCount};
    }

    static int[] minimumOptimal(int[][] mat,int N){
        int rowNumber=0;
        int count=0;
        int j=N-1;
        for (int i = 0; i <N ; i++) {

            while (j>=0 && mat[i][j]==1){
                rowNumber=i;
                j--;
                count++;
            }
        }
        return new int[] {rowNumber,count};
    }
}
