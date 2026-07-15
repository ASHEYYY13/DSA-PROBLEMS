package slidingWindow;

public class maxSumSubarrayOfK {
    public static void main(String[] args) {
        int[] arr={100,200,300,400};
        System.out.println(maxSubArray(arr,2));
    }

    private static int maxSubArray(int[] arr,int k) {
        int totalSum=Integer.MIN_VALUE;
        int currentSum=0;
        for (int i = 0; i <k ; i++) {
            currentSum+=arr[i];
        }
        if(currentSum>totalSum){
            totalSum=currentSum;
        }
        for (int i = k; i <arr.length ; i++) {
            currentSum-=arr[i-k];
            currentSum+=arr[i];
            if(currentSum>totalSum){
                totalSum=currentSum;
            }
        }
        return totalSum;
    }
}
