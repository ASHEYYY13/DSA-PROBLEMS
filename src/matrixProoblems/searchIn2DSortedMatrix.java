package matrixProoblems;

public class searchIn2DSortedMatrix {
    public static void main(String[] args) {
        int[][] mat={
                {1, 5, 9},
                {14, 20, 21},
                {30, 34, 43}
        };
        System.out.println(searchInMatrixOtherApproach(mat,14));
    }
    //this   is the optimal solutionn for search in 2D Array
    //If  the  give matrix is sorted in coloum wise and row seperately use this
    private static boolean searchInMatrix(int[][] mat, int target) {
        int row=0;
        int col=mat[0].length-1;;
        while(row<mat.length && col>=0){
            if(mat[row][col]==target) {
                return true;
            }
            if(mat[row][col]<target) {
                row++;
            }
            else {
                col--;
            }
        }
        return false;

    }
//if  the row and column sorted inn same other
    private static boolean searchInMatrixOtherApproach(int[][] mat, int target) {
        int start=0;
        int end=mat.length*mat[0].length-1;;
        while(start<=end){
            int mid=start+(end-start)/2;
            int row=mid/ mat.length;
            int col=mid% mat.length;
            if(mat[row][col]==target) {
                return true;
            }
            if(mat[row][col]<target) {
                start=mid+1;
            }
            else {
                end=mid-1;
            }
        }
        return false;

    }

}
