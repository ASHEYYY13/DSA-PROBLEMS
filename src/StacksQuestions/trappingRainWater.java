package StacksQuestions;

public class trappingRainWater {
    public static void main(String[] args) {
        int[] arr={2, 1, 5, 3, 1, 0, 4};
        System.out.println(maxRainWaterOptimal(arr));
    }

    private static int maxRainWater(int[] arr) {
        int n=arr.length;
        int[] prefixMax=new int[n];
        prefixMax[0]=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            prefixMax[i]=Math.max(prefixMax[i-1],arr[i]);
        }
        int[] suffixMax=new int[n];
        suffixMax[n-1]=arr[n-1];
        for (int i = arr.length-2; i >=0 ; i--) {
            suffixMax[i]=Math.max(suffixMax[i+1],arr[i]);
        }


        int max=0;
        for (int i=0;i<arr.length;i++){
            int  leftMax=prefixMax[i];
            int rightMax=suffixMax[i];
            if(arr[i]<leftMax && arr[i]<rightMax){
                max+=Math.min(leftMax,rightMax)-arr[i];
            }
        }
        return max;
    }
    private static int maxRainWaterOptimal(int[] arr){
        int leftMax=0,rightMax=0,sum=0;
        int left=0;
        int right=arr.length-1;
        while (left<right){
            if(arr[left]<=arr[right]) {
                if (leftMax > arr[left]) {
                    sum += leftMax - arr[left];
                }
                else {
                    leftMax=arr[left];
                }
                left=left+1;
            }
            else {
                if(rightMax>arr[right]){
                    sum+=rightMax-arr[right];
                }
                else {
                    rightMax=arr[right];
                }
                right=right-1;
            }

        }
        return sum;
    }
}
