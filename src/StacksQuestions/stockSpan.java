package StacksQuestions;

import java.util.ArrayList;
import java.util.Stack;

public class stockSpan {
    public static void main(String[] args) {
        int[] arr={10, 4, 5, 90, 120, 80};
        System.out.println(stockOptimized(arr));
    }

    private static ArrayList<Integer> stock(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();
       Stack<Integer> st=new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            int price=1;
            for (int j =i-1;j>=0;j--) {
                if(arr[i]>arr[j]){
                    price++;
                }
                else {
                    break;
                }
            }
            ans.add(price);
        }
        return ans;
    }

    private static ArrayList<Integer> stockOptimized(int[] arr) {
        ArrayList<Integer> ans=new ArrayList<>();

        for (int i = 0; i <arr.length ; i++) {
            ans.add(i);
        }
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            while (!st.isEmpty() && arr[st.peek()]<arr[i]){
                    st.pop();
            }
            if(st.isEmpty()) {
                ans.set(i,(i+1));
            }
            else {
                ans.set(i,i-st.peek());
            }
            st.push(i);
        }
        return ans;
    }
}
