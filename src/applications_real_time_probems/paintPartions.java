package applications_real_time_probems;

public class paintPartions {
    public static void main(String[] args) {
    int[] arr={5, 10, 30, 20, 15};
        System.out.println(maxOfOnePainterBinearySearch(arr,3));
    }
    private static int maxOfOnePainter(int[] arr, int S) {
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
            int numberOfStudent=AllocatePainter(arr,i);
            if(numberOfStudent<=S){
                return i;
            }
        }
        return -1;
    }

    private static int maxOfOnePainterBinearySearch(int[] arr, int S) {
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
            if(AllocatePainter(arr,mid)<=S){
                high=mid-1;
            }
            else{
                low=mid+1;
            }
        }
        return low;
    }


    private static int AllocatePainter(int[] arr, int maxPages) {
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
