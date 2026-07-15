package applications_real_time_probems;

public class ShipLeastCapacity {
    public static void main(String[] args) {
    int[] arr={1,2,3,4,5,6,7};
        System.out.println(shipCapacityBinearySearch(arr,5));
    }
    private static int shipCapacity(int[] arr, int S) {
        int low=arr[0];
        int high=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            high+=arr[i];
            if(arr[i]>low)
                low=arr[i];
        }
        if(arr.length<S){
            return -1;
        }
        if(S==arr.length){
            return low;
        }
        if(S==1){
            return high;
        }

        for (int i = low; i <high+1 ; i++) {
            int weight=AllocateShipWeigh(arr,i);
            if(weight<=S){
                return i;
            }
        }
        return -1;
    }

    private static int shipCapacityBinearySearch(int[] arr, int S) {
        int low=arr[0];
        int high=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            high+=arr[i];
            if(arr[i]>low)
                low=arr[i];
        }
        if(arr.length<S){
            return -1;
        }
        if(S==arr.length){
            return low;
        }
        if(S==1){
            return high;
        }

        while (low<=high){
            int mid=low+(high-low)/2;
            if(AllocateShipWeigh(arr,mid)<=S){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }

    private static int AllocateShipWeigh(int[] arr, int maxWeight) {
        int totalWeight=1;
        int weight=0;
        for (int j = 0; j <arr.length ; j++) {
            if(weight+arr[j]<=maxWeight){
                weight=weight+arr[j];
            }
            else {
                totalWeight++;
                weight=arr[j];
            }
        }
        return totalWeight;

    }
}
