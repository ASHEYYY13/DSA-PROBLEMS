package StacksQuestions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static void main(String[] args) {
        int[] arr={6,8,0,1,3};
        System.out.println(Arrays.toString(greaterNextElement2(arr)));
    }

    //Brute Force
    static ArrayList<Integer> greaterElement(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
               int nextGreat=-1;
            for (int j = i+1; j <arr.length ; j++) {
                if(arr[i]<arr[j]){
                    nextGreat=arr[j];
                    break;
                }
            }
            list.add(nextGreat);
        }
     return list;
    }
    //optimized solution
    static ArrayList<Integer> greaterElementOptimized(int[] arr){
        ArrayList<Integer> list=new ArrayList<>();
        Stack<Integer> st=new Stack<>();
        for (int i = 0; i <arr.length ; i++) {
            list.add(-1);
        }
        for (int i = arr.length-1; i >=0 ; i--) {
            while (!st.isEmpty() && st.peek()<=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                list.set(i,st.peek());
            }
            st.push(arr[i]);
        }
        return list;
    }
  static int[] greaterNextElement2(int[] arr){
        int n=arr.length;
      Stack<Integer> st=new Stack<>();
      int[] ans=new int[n];
      for (int i = n*2-1; i >=0 ; i--) {
          while (!st.isEmpty() && st.peek()<=arr[i%n]){
              st.pop();
          }
          if(!st.isEmpty()){
              ans[i%n]=st.peek();
          }
          else {
             ans[i%n]=-1;
          }
          st.push(arr[i%n]);
      }
     return ans;
  }
}
