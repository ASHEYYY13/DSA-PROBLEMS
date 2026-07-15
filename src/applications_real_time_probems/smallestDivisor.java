package applications_real_time_probems;

public class smallestDivisor {
    public static void main(String[] args) {
        int[] arr={1,2,5,9};
        System.out.println(findsmalldivisorwithThreshHold(arr,6));
    }

    private static int findsmalldivisorwithThreshHold(int[] arr, int Threshold) {
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        for (int i = 1; i <=max; i++) {
            if(sumUsingDivisor(arr,i,Threshold)){
                return i;
            }
        }
        return -1;
    }


    private static int findsmalldivisorwithThreshHoldBinarySearch(int[] arr, int Threshold) {
        int max=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(arr[i]>max){
                max=arr[i];
            }
        }
        int low=1;
        int high= Integer.MAX_VALUE;
       while (low<high){
           int mid=low+(high-low)/2;
           if(sumUsingDivisor(arr,mid,Threshold)){
               high=mid;
           }
           else {
               low=mid+1;
           }
       }
       return high;
    }

    private static boolean sumUsingDivisor(int[] arr, int divisor, int threshold) {
        int sum=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]%divisor==0){
                sum=sum+arr[i]/divisor;
            }
            else {
                sum=sum+arr[i]/divisor+1;
            }
        }
        return sum<=threshold;
    }
}