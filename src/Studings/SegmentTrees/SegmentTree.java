package Studings.SegmentTrees;

public class SegmentTree {
    private static class Node{
        int data;
        int startingInterval;
        int endingInterval;
        Node right;
        Node left;

        public Node(int startingInterval,int endingInterval){
            this.startingInterval=startingInterval;
            this.endingInterval=endingInterval;
        }

    }
}
