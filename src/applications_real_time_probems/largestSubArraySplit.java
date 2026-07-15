package applications_real_time_probems;

public class largestSubArraySplit{
    public static void main(String[] args) {
        int[] arr={2,3,2,1,1};
        System.out.println(minSplit(arr,arr.length,4));
    }

    private static int minSplit(int[] arr, int length, int S) {
        int low=arr[0];
        int high=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            high+=arr[i];
            if(arr[i]>low)
                low=arr[i];
        }
//        if(arr.length<S){
//            return -1;
//        }
        if(S==arr.length){
            return low;
        }
        if(S==1){
            return high;
        }

        while (low<=high){
            int mid=low+(high-low)/2;
            if(subArray(arr,mid)<=S){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }


    private static int subArray(int[] arr, int maxPages) {
        int student=1;
        int numberPages=0;
        for (int j = 0; j <arr.length ; j++) {
            if(numberPages+arr[j]<=maxPages){
                numberPages=numberPages+arr[j];
            }
            else {
                student++;
                numberPages=arr[j];
            }
        }
        return student;
    }
}
