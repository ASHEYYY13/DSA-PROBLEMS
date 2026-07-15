package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class subArrayOfSumZero {
    public static void main(String[] args) {
        int[] arr={4, 2, -3, 1, 6};
        System.out.println(sumZeroOptimal(arr));
    }

    private static boolean sumZero(int[] arr) {
        int n=arr.length;

        for (int i = 0; i <arr.length ; i++) {
            int sum=0;
            for (int j = i; j <arr.length ; j++) {
                sum+=arr[j];

                if(sum==0){
                    return true;
                }
            }
        }
        return false;
    }
    private static boolean sumZeroOptimal(int[] arr) {
        Set<Integer> set=new HashSet<>();
       int sum=0;
        for (int i = 0; i < arr.length ; i++) {
            sum+=arr[i];

            if(arr[i]==0 || sum==0 || set.contains(sum)){
                return true;
            }
            set.add(sum);
        }
        return false;
    }
}
