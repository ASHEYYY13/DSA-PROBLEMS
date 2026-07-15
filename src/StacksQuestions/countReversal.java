package StacksQuestions;

import java.util.Stack;

public class countReversal {
    public static void main(String[] args) {
        String s="}{{}}{{{";
        System.out.println(countMinReversal(s));
    }

    private static int countMinReversal(String s) {
        int n = s.length();

        if(n % 2 != 0){
            return -1;
        }
        Stack<Character> st=new Stack<>();

        for(char ch : s.toCharArray()){
            if(ch == '{'){
                st.push(ch);
            }

            else{
                if(!st.empty() && st.peek() == '{'){
                    st.pop();
                }
                else{
                    st.push(ch);
                }
            }
        }


        int opencount = 0, closecount = 0;
        while(!st.empty()){
            if(st.peek() == '{')
                opencount++;
            else
                closecount++;
            st.pop();
        }


        return (opencount + 1)/2 + (closecount + 1)/2;
    }
}
