package StacksQuestions;

import java.util.Stack;

public class reverseStack {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(5);
        st.push(4);
        st.push(3);
        st.push(2);
        st.push(10);

//        reverse(st);
        System.out.println(sortStack(st));
    }
    private static void reverse(Stack<Integer> stack){
       int[] arr=new int[stack.size()];

        for (int i = 0; i <arr.length ; i++) {
            arr[i]=stack.pop();
        }
        for (int i =0; i <arr.length; i++) {
            stack.push(arr[i]);
        }
    }


    private static Stack<Integer> sortStack(Stack<Integer> st){
        Stack<Integer> temp=new Stack<>();
        while (!st.isEmpty()) {
            int popped = st.pop();

            while (!temp.isEmpty() && temp.peek() >popped) {
                st.push(temp.pop());
            }
            temp.push(popped);

        }
        return temp;
    }
}
