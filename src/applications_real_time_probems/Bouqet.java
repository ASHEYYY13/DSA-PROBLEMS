package applications_real_time_probems;

public class Bouqet {
    public static void main(String[] args) {
     int[] arr={7,7,7,7,11,7};
        System.out.println(minBouqet(arr,2,3));
        System.out.println(arr.length);
    }
    static int minBouqet(int[] arr,int m,int k){//m bouqes and with k adjacent flower
        if(k*m>arr.length){
            return 1;
        }
//        int min=arr[0];
//        int max=arr[0];
//        for (int i = 0; i <arr.length ; i++) {
//            if (arr[i]>max){
//                max=arr[i];
//            }
//            if(arr[i]<min){
//                min=arr[i];
//            }
//        }
        for (int i = 0; i <=arr.length ; i++) {
            if(canMakeBouquet(arr,arr[i],k)==m){
                return arr[i];
            }
        }
        return -1;
    }
    static int minBouqetBinerySearch(int[] arr,int m,int k){
        if(k*m>arr.length){
            return 1;
        }
        int min=arr[0];
        int max=arr[0];
        for (int i = 0; i <arr.length ; i++) {
            if (arr[i]>max){
                max=arr[i];
            }
            if(arr[i]<min){
                min=arr[i];
            }
        }
        if(k*m==1){
            return min;
        }
        if(k*m==arr.length){
            return max;
        }
        while(min<=max){
            int mid=min+(max-min)/2;
            if(canMakeBouquet(arr,mid,k)>=m){
                max=mid-1;
            }
            else {
                min=mid+1;
            }
        }
        return min;
    }
    private static int canMakeBouquet(int[] arr, int days, int flowers) {
        int noOfFlowers=0;
        int noOfBouquets=0;
        for (int i = 0; i <arr.length ; i++) {
            if(arr[i]<=days){
                noOfFlowers++;
                if(noOfFlowers==flowers){
                    noOfBouquets++;
                    noOfFlowers=0;
                }
            }
            else {
                noOfFlowers=0;
            }
        }
        return noOfBouquets;
    }
}
