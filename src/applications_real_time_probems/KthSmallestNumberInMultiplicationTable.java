package applications_real_time_probems;

import java.util.Arrays;

public class KthSmallestNumberInMultiplicationTable {
    public static void main(String[] args) {
        int m=2;
        int n=3;
        System.out.println(findKthDigitBinarySearch(m,n,6));
    }

    private static int findKthDigit(int m, int n, int k) {
        int[] arr=new int[m*n];
       int count=0;
        for (int i = 1; i <=m ; i++) {
            for (int j = 1; j <=n ; j++) {
                arr[count++]=i*j;
            }
        }
        Arrays.sort(arr);
        return arr[k-1];
    }

    private static int findKthDigitBinarySearch(int m, int n, int k) {
        int low=1;
        int high=m*n;
        while (low<=high){
            int mid=low+(high-low)/2;
            if(smallestNumber(mid,m,n)<k){
                low=mid+1;
            }

            else {
                high=mid-1;
            }
        }
       return low;
    }

    private static int smallestNumber(int mid, int m, int n) {
        int sum=0;
        for (int i = 1; i <=m ; i++) {
            sum += Math.min(mid / i, n);

        }
        return sum;
    }


}
