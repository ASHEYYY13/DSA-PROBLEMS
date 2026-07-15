package StacksQuestions;

import java.util.Stack;

public class MaxRectangle {
    public static void main(String[] args) {
        int[][] mat={
            {0,1,1,0},
            {1,1,1,1},
            {1,1,1,1},
            {1,1,0,0}
        };
        System.out.println(MaxAreaOfRectangle(mat));
    }

    private static int MaxAreaOfRectangle(int[][] mat) {
        int m=mat.length;
        int n=mat[0].length;
        int maxArea=0;
        int[][] preSum=new int[m][n];
        for (int j = 0; j <n ; j++) {
            int sum=0;
            for (int i = 0; i <m ; i++) {
                sum=sum+mat[i][j];
                if(mat[i][j]==0){
                    sum=0;
                }
                preSum[i][j]=sum;
            }
        }
        for (int i = 0; i <m ; i++) {
             maxArea=Math.max(maxArea,largestRectangleHistogram(preSum[i]));
        }
        return maxArea;
    }
    private static int largestRectangleHistogram(int[] arr) {
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
