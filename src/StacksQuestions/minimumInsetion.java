package StacksQuestions;

import java.util.Stack;

public class minimumInsetion {
    public static void main(String[] args) {
        String s="())";
        System.out.println(minimum(s));
    }
    private static int minimum(String s){
        Stack<Character> st=new Stack<>();
        for(char ch:s.toCharArray()){
            if(ch==')'){
                if(!st.isEmpty() && st.peek()=='('){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
            else {
                st.push(ch);
            }
        }
        return st.size();
    }
}
