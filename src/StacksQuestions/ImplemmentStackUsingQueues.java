package StacksQuestions;

import java.util.Stack;

public class ImplemmentStackUsingQueues {
    private Stack<Integer> first;
    private Stack<Integer> second;

    public ImplemmentStackUsingQueues() {
        this.first = new Stack<>();
        this.second = new Stack<>();
    }

    public void add(int item){
        first.push(item);
    }

    public void add2(int item){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        first.push(item);
        while (!second.isEmpty()){
            first.push(second.pop());
        }
    }
    public int remove(){
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int removed=second.pop();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }

    public int remove2(){
        return first.pop();
    }

    public int peek() throws Exception{
        while (!first.isEmpty()){
            second.push(first.pop());
        }
        int removed=second.peek();
        while (!second.isEmpty()){
            first.push(second.pop());
        }
        return removed;
    }


    public int peek2(){
        return first.peek();
    }

    public boolean isempt(){
        return first.isEmpty();
    }


    public static void main(String[] args) {
        Stack<Integer> first=new Stack<>();
        Stack<Integer> second=new Stack<>();
        ImplemmentStackUsingQueues st=new ImplemmentStackUsingQueues();
        st.add(10);
        st.add(20);
        System.out.println(st.remove());

    }
}
