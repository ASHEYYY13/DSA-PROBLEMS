package StacksQuestions;

import java.util.Stack;

public class LargestRectangleInHistogram {
    public static void main(String[] args) {
        int[] arr={2,1,5,6,2,3};
        System.out.println(largestRectangleOptimalAnotherApproach(arr));
    }

    private static int largestRectangle(int[] arr) {
        int max=0;
        for (int i = 0; i <arr.length ; i++) {
            int sum=arr[i];
            for (int j = 0; j <arr.length ; j++) {
                if(i==j){
                    continue;
                }
                if(arr[j]>=arr[i]){
                    sum+=arr[i];
                }
                else {
                    if(i>j) {
                        sum = arr[i];
                    }
                    else {
                        break;
                    }
                }
            }
            if(sum>max){
                max=sum;
            }
        }
        return max;
    }


    private static int largestRectangleOptimal(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int max=0;
        st.push(0);
        for (int i = 0; i <arr.length; i++) {
            while (!st.isEmpty() && arr[i]<arr[st.peek()]){
                max=getMax(arr,st,max,i);
            }
            st.push(i);
        }
        int i=arr.length;
        while (!st.isEmpty()){
            max=getMax(arr,st,max,i);
        }
        return max;
    }
    private static int getMax(int[] arr,Stack<Integer> st,int max,int i){
        int area;
         int popped=st.pop();
         if(st.isEmpty()){
             area=arr[popped]*i;
         }
         else {
             area=arr[popped]*(i-1-st.peek());
         }
        return Math.max(max,area);
    }

    private static int largestRectangleOptimalAnotherApproach(int[] arr) {
        Stack<Integer> st=new Stack<>();
        int maxArea=0;
        int n=arr.length;
        for (int i = 0; i <n ; i++) {
            while(!st.isEmpty() && arr[st.peek()]>=arr[i] ){
                 int tp=st.pop();
                 int nse=i;
                 int pse=st.isEmpty()?-1:st.peek();
                 int Area=arr[tp]*(nse-pse-1);
                 maxArea=Math.max(maxArea,Area);
            }
            st.push(i);
        }
        while (!st.isEmpty()){
            int tp=st.pop();
            int nse=n;
            int pse=st.isEmpty()?-1:st.peek();
            int Area=arr[tp]*(nse-pse-1);
            maxArea=Math.max(maxArea,Area);
        }
        return maxArea;
    }
}
