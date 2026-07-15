package QueueQuestions;

import java.util.HashMap;
import java.util.Map;

public class LruCache {

    Map<Integer,Node> map;
     private Node head;
     private Node tail;
    int capacity;
    public LruCache(int capacity) {
        this.capacity=capacity;
        map=new HashMap<>();
        this.head = new Node(-1, -1);
        this.tail = new Node(-1, -1);
        this.head.next = this.tail;
        this.tail.prev = this.head;

    }
  private static class Node{
      int value;
      int key;
      Node next;
      Node prev;

      public Node(int key,int value) {
          this.value = value;
          this.key = key;
          this.next=null;
          this.prev=null;
      }
    }

    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node=map.get(key);
        deleteNode(node);
        insertAfter(node);
        return node.value;
    }

    private void deleteNode(Node node) {
        Node prevNode=node.prev;
        Node nextNode=node.next;
        prevNode.next=nextNode;
        nextNode.prev=prevNode;
    }

    private void insertAfter(Node node) {
        Node headNextNode=head.next;
        head.next=node;
        node.next=headNextNode;
        node.prev=head;
        headNextNode.prev=node;
    }

    public void put(int key,int value){
        if (map.containsKey(key)){
            Node node=map.get(key);
            node.value=value;
            deleteNode(node);
            insertAfter(node);
        }
        else {
            if(map.size()==capacity){
                Node node=tail.prev;
                map.remove(node.key);
                deleteNode(node);
            }
            Node node= new Node(key, value);
            map.put(key,node);
            insertAfter(node);
        }
    }
}


