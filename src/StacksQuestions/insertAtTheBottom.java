package StacksQuestions;

import java.util.Stack;

public class insertAtTheBottom {
    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(2);
        st.push(6);
        st.push(5);
        st.push(8);
        st.push(3);
        st.push(10);
        System.out.println(innsertBottom(st,4));
    }

    private static Stack<Integer> innsertBottom(Stack<Integer> st, int i) {
        Stack<Integer> temp=new Stack<>();
        while (!st.isEmpty()){
            temp.push(st.pop());
        }
        st.push(i);
        while (!temp.isEmpty()){
            st.push(temp.pop());
        }
        return temp;
    }
}
