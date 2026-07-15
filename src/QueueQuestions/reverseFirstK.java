package QueueQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseFirstK {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        System.out.println(reverse(queue,3));
    }

    private static Queue<Integer> reverse(Queue<Integer> queue, int K) {

        Stack<Integer> st=new Stack<>();
        for (int i = 0; i <K ; i++) {
           st.push(queue.poll());
        }
        Queue<Integer> temp=new LinkedList<>();
        while (!queue.isEmpty()){
            temp.add(queue.poll());
        }
        while (!st.isEmpty()){
            queue.add(st.pop());
        }
        while (!temp.isEmpty()){
            queue.add(temp.poll());;
        }
        return queue;
    }
}
