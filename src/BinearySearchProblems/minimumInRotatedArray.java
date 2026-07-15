package BinearySearchProblems;

public class minimumInRotatedArray {
    public static void main(String[] args) {
        int[] arr={2,3,4,5,6,7,8,9,10,1};
        System.out.println(minimum(arr,0,arr.length-1));
    }

    private static int minimum(int[] arr, int start, int end) {
        int ans=Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]<=arr[end]){
                if(ans>arr[mid]){ ans=arr[mid];}
                end=mid-1;
            }

            else {
                if(ans<arr[start]){
                    ans=arr[mid];
                }
                start=mid+1;
            }
        }
        return ans;
    }
}
