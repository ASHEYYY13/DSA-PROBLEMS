package Stacks;

import java.util.*;

public abstract class inbuildStacksAndQueues implements Queue<Integer>{

    public static void main(String[] args) {
        Stack<Integer> st=new Stack<>();
        st.push(10);
        st.push(20);
        st.push(20);
        st.push(30);
        st.push(100);
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());
//        System.out.println(st.pop());

        Queue<Integer> queue=new LinkedList<>();
            queue.add(8);
            queue.add(10);
            queue.add(27);
//        System.out.println(queue.peek());
//        System.out.println(queue.poll());
//        System.out.println(queue.poll());\
        Deque<Integer> deque=new ArrayDeque<>();
       deque.add(10);
       deque.addLast(50);
       deque.addFirst(80);
        System.out.println(deque.peek());


    }
}
