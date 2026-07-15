package applications_real_time_probems;

public class kokoEatingBanana {
    public static void main(String[] args) {
        int[] arr={30,11,23,4,20};
        System.out.println(minBananaPerHourBinerySearch(arr,5));
    }

    private static int minBananaPerHour(int[] arr, int hours) {

       long high=arr[0];
        for (int i = 1; i <arr.length ; i++) {
         if(high<arr[i]){
             high=arr[i];
         }
        }
//       long low=(int) high/hours;
        for (int i = 1; i < high ; i++) {
            if(possibleToEat(arr,i)>=hours){
                return i;
            }
        }
        return -1;
    }
    private static int minBananaPerHourBinerySearch(int[] arr, int hours) {
        int high=arr[0];
        for (int i = 1; i <arr.length ; i++) {
            if(high<arr[i]){
                high=arr[i];
            }
        }
        int low=1;
        while (low<high){
            int mid=low+((int) high-low)/2;
            if(possibleToEat(arr,mid)<=hours){
              high=mid;
            }
            else {
             low=mid+1;
            }

        }
        return low;
    }

    private static int possibleToEat(int[] arr, int BananaPerHour) {
        int hours=0;
        for (int i = 0; i <arr.length ; i++) {
            int div = arr[i]/BananaPerHour;
            hours += div;
            if(arr[i] % BananaPerHour != 0)
            {
                hours++;
            }
        }
        return hours;
    }
}
