package BinearySearchProblems;

public class BiatonicArray {
    public static void main(String[] args) {
        int[] arr={1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 19, 18, 17, 16, 15, 14, 13, 12, 11};
        System.out.println(solve(arr,12));
    }
    public static int solve(int[] A, int B) {
        int start=0;
        int end=A.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(A[mid]==B){
                return mid;
            }
            if(A[mid]<=A[mid+1]){
                if(A[mid]>=B && A[start]<=B){
                   end=mid-1;
                }
                else{
                    start=mid+1;
                }
            }
            else {
                if(A[mid]>=B && A[end]<=B){
                    start=mid+1;
                }
                else {
                    end=mid-1;
                }
            }
        }
        return -1;
    }

}
