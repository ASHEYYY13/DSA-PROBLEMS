package slidingWindow;

import java.util.*;

public class maximumOfEverySubArray {
    public static void main(String[] args) {
        int[] arr={8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
        System.out.println(maxOfEachSubArrayOptimal(arr,4));

    }

    private static ArrayList<Integer> maxOfEachSubArray(int[] arr,int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        int n=arr.length;
        for (int i = 0; i <=n-k ; i++) {
            int max=Integer.MIN_VALUE;
            for (int j = i; j <i+k ; j++) {
              max=Math.max(max,arr[j]);
            }
            ans.add(max);
        }
        return ans;
    }

    private static ArrayList<Integer> maxOfEachSubArrayOptimal(int[] arr,int k) {
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> dq=new LinkedList<>();
        for (int i = 0; i <k ; i++) {
            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        for (int i = k; i <n ; i++) {
             ans.add(arr[dq.peekFirst()]);

             while (!dq.isEmpty() && dq.peekFirst()<i-k+1){
                 dq.pollFirst();
             }

            while (!dq.isEmpty() && arr[i]>=arr[dq.peekLast()]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        ans.add(arr[dq.pollFirst()]);
        return ans;
    }
}
