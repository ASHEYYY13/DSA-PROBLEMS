package QueueQuestions.greedyQueueQuestions;

import java.util.PriorityQueue;

public class minimumCostForRopes {
    public static void main(String[] args) {
        int[] arr={4, 2, 7, 6, 9};
        System.out.println(minOfRopes(arr));
    }

    private static int minOfRopes(int[] arr) {
        int totalCost=0;
        PriorityQueue<Integer> priorityQueue=new PriorityQueue<>();
        for(int rope:arr){
            priorityQueue.add(rope);
        }

        while (priorityQueue.size()>1){
            int first=priorityQueue.poll();
            int second=priorityQueue.poll();
            int cost=first+second;
            totalCost+=cost;
            priorityQueue.add(cost);
        }
        return totalCost;
    }

}
