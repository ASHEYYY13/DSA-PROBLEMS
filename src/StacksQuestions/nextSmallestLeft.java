package StacksQuestions;

import java.util.Arrays;
import java.util.Stack;

public class nextSmallestLeft {
    public static void main(String[] args) {
        int[] arr={3, 8, 5, 2, 25};
        System.out.println(Arrays.toString(nextSmallest(arr)));
    }

    private static int[] nextSmallest(int[] arr) {
        int n=arr.length;
        int[] ans=new int[n];
        Stack<Integer> st=new Stack<>();
        for (int i = n-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek()>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
               ans[i]=st.peek();
            }
            else {
                ans[i]=-1;
            }
            st.push(arr[i]);
        }
        return ans;
    }
}
