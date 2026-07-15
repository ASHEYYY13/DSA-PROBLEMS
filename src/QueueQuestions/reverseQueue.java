package QueueQuestions;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class reverseQueue {
    public static void main(String[] args) {
        Queue<Integer> queue=new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(reverse(queue));
    }
    private static Queue<Integer>  reverse(Queue<Integer> queue){
        Stack<Integer> temp=new Stack<>();
        while (!queue.isEmpty()){
            temp.push(queue.remove());
        }
        while (!temp.isEmpty()){
            queue.add(temp.pop());
        }
        return queue;
    }
}
