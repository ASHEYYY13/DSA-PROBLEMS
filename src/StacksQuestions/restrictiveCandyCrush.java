package StacksQuestions;

import java.util.Stack;

public class restrictiveCandyCrush {
    public static void main(String[] args) {
        String name="geeksforgeeks";
        System.out.println(reduceString(name,2));
    }

    private static String reduceString(String input,int k) {
        Stack<Character> st=new Stack<>();
        int i=0;
        while (i<input.length()){
            char ch=input.charAt(i++);
            st.push(ch);
            int count=0;
            while (!st.isEmpty() && st.peek()==ch){
                count++;
                st.pop();
            }
            if(count==k){
                continue;
            }
            else {
                while (count>0){
                    st.push(ch);
                    count--;
                }
            }
        }
        StringBuilder res=new StringBuilder();
        while (!st.isEmpty()){
            res.insert(0,st.pop());
        }
        return res.toString();
    }
}
