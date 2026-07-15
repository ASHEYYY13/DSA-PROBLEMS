package slidingWindow;

import java.util.*;

public class firstNegativeInEachWindow {
    public static void main(String[] args) {
        int[] arr={12, -1, -7, 8, -15, 30, 16, 28};
        System.out.println(firstNegativeWindowBetterApproach(arr,3));
    }

    private static List<Integer> firstNegativeWindow(int[] arr, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        Queue<Integer> queue=new LinkedList<>();
        for (int i = 0; i <k ; i++) {
            queue.add(arr[i]);
        }
        ans.add(firstNegative(queue));
        for (int i = k; i <arr.length ; i++) {
            queue.remove();
            queue.add(arr[i]);
            ans.add(firstNegative(queue));
        }
        return ans;
    }

    private static int firstNegative(Queue<Integer> queue) {
        for (int num:queue){
            if(num<0){
                return num;
            }
        }
        return 0;
    }

    private static List<Integer> firstNegativeWindowBetterApproach(int[] arr, int k) {
        int n=arr.length;
        ArrayList<Integer> ans=new ArrayList<>();
        Deque<Integer> deque=new LinkedList<>();
        for (int i = 0; i <k ; i++) {
           if(arr[i]<0){
               deque.addLast(i);
           }
        }
        for (int i = k; i <n ; i++) {
            if(!deque.isEmpty()){
                ans.add(arr[deque.peekFirst()]);
            }
            else {
                ans.add(0);
            }


            while (!deque.isEmpty() && deque.peekFirst()<(i-k+1)) {
                deque.pollFirst();
            }

            if(arr[i]<0){
                deque.addLast(i);
            }

        }
        if(!deque.isEmpty()){
            ans.add(arr[deque.peekFirst()]);
        }
        else {
            ans.add(0);
        }
       return ans;
    }

}
