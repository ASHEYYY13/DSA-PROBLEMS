package StacksQuestions;

import java.util.Stack;

public class infixToPostfix {
    public static void main(String[] args) {
        String s="a+b*(c^d-e)^(f+g*h)-i";
//        System.out.println(convertInfixToPostfix(s));
        String[] arr={"2", "3", "1", "*", "+", "9", "-"};
        System.out.println(postFixEvaluation(arr));
    }

    private static String convertInfixToPostfix(String s) {
        int i=0;
        StringBuilder ans=new StringBuilder();
        Stack<Character> st=new Stack<>();
        for (char c:s.toCharArray()){
            if(Character.isLetterOrDigit(c)){
                ans.append(c);
            }
            else if(c=='('){
                st.push(c);
            }
            else if(c==')'){
                while (!st.isEmpty() && st.peek()!='('){
                    ans.append(st.pop());
                }
                st.pop();
            }
            else {
                while (!st.isEmpty() && priority(st.peek())>=priority(c)){
                    ans.append(st.pop());
                }
                st.push(c);
            }
        }

        while (!st.isEmpty()) {
            ans.append(st.pop());
        }



        return ans.toString();
    }

    static int priority(char c){
        if(c=='^'){
            return 3;
        }
        else if(c=='*' || c=='/'){
            return 2;
        }
        else if(c=='+' || c=='-'){
            return 1;
        }
        else {
            return -1;
        }
    }

    private static int postFixEvaluation(String[] arr){
        Stack<Integer> st=new Stack<>();
        for (String s:arr){
            if(isNumber(s)){
                st.push(Integer.parseInt(s));
            }
            else{
              int val=st.pop();
              int val2=st.pop();
              switch (s){
                  case "+":
                      st.push(val2+val);
                     break;
                  case "-":
                      st.push(val2-val);
                      break;
                  case "*":
                      st.push(val2*val);
                      break;
                  case "/":
                      st.push(val2/val);
                      break;
              }
            }
        }
        return st.pop();
    }

    private static boolean isNumber(String s) {
        try {
            Integer.parseInt(s);
            return true;
        }
        catch (Exception e){
            return false;
        }
    }
}
