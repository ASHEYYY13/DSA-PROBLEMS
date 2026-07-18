package twoPointers;

public class TrappingRainWatar {
    public static int trap(int[] height) {
        int result=0;
        for (int i = 1; i <height.length-1 ; i++) {
            int leftMax=height[i];
            for (int j = 0; j <i ; j++) {
                leftMax=Math.max(leftMax,height[j]);
            }
            int rightMax=height[i];
            for (int j = i+1; j <height.length ; j++) {
                rightMax=Math.max(rightMax,height[j]);
            }
            result+=Math.min(leftMax,rightMax)-height[i];
        }
        return result;
    }

    public static int maxRainWaterBetterApproach(int[] arr) {
        int n= arr.length;
        int[] left=new int[n];
        int[] right=new int[n];
        left[0]=arr[0];
        for (int i = 1; i<n ; i++) {
            left[i]=Math.max(left[i-1],arr[i]);
        }

        right[n-1]=arr[n-1];
        for (int i = n-2; i >=0 ; i--) {
            right[i]=Math.max(right[i+1],arr[i]);
        }

        int max=0;
        for (int i=1;i<arr.length-1;i++){
            int  leftMax=left[i];
            int rightMax=right[i];
            if(arr[i]<leftMax && arr[i]<rightMax){
                max+=Math.min(leftMax,rightMax)-arr[i];
            }
        }
        return max;
    }

    public static int maxRainWaterBetterOptimalTwoPointers(int[] arr) {
       int left=1;
       int right=arr.length-2;
       int leftMax=arr[left-1];
       int rightMax=arr[right+1];

       int res=0;
       while (left<=right){

           if(rightMax<=leftMax){
               res+=Math.max(0,rightMax-arr[right]);
               rightMax=Math.max(rightMax,arr[right]);
               right--;
           }
           else {
               res+=Math.max(0,leftMax-arr[left]);
               leftMax=Math.max(leftMax,arr[left]);
               left++;
           }
       }
       return res;
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
