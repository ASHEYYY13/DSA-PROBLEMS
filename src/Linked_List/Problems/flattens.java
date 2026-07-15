package Linked_List.Problems;

import java.util.ArrayList;
import java.util.Collections;

public class flattens {
    private static Node current;
    private Node head;
    private Node tail;
    int size;

    public int getSize() {
        return size;
    }

    public void insertFirst(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        if (tail == null) {
            tail = head;
        }
        size += 1;
    }

    public void add(int value) {
        if (tail == null) {
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
//        tail.next=head.next;

        size += 1;
    }
    public void addBottom(int value){
        Node node=new Node(value);
        if(tail.bottom==null){
            tail.bottom=node;
            return;
        }
        Node temp=tail.bottom;
        while (temp.bottom!=null){
            temp=temp.bottom;
        }
        temp.bottom=node;
    }

    public void display() {
      Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            Node t2=temp;
            while (t2.bottom!=null){
                t2=t2.bottom;
                System.out.print("|  "+t2.data );
            }
            temp = temp.next;
        }
        System.out.print("  END");
//        System.out.println();
    }

    static class Node {
        private Node next;
        private Node bottom;
        private int data;

        public Node(int value) {
            this.data = value;
        }

        public Node(Node next, int value) {
            this.next = next;
            this.data = value;
        }
    }


    public static void main(String[] args) {
        flattens ft=new flattens();
        ft.add(1);
        ft.add(2);
        ft.addBottom(3);
        ft.addBottom(9);
        ft.add(6);
        ft.add(8);
        ft.add(40);
//        ft.display();
     Node res=   flattenLLOptimal(ft.head);
     displayWithHeadBottom(res);
    }
//this works but this is not an  optimal approach
    static Node flattensLL(Node head){
        ArrayList<Integer> list=new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            list.add(temp.data);
            Node t2=temp;
            while (t2.bottom!=null){
                t2=t2.bottom;
                list.add(t2.data);
            }
            temp = temp.next;
        }
        Collections.sort(list);
        Node dummyNode=new Node(-1);
        Node dummy=dummyNode;
        for(int num:list){
          Node node=new Node(num);
          dummy.bottom=node;
          dummy=dummy.bottom;
        }
        displayWithHeadBottom(dummyNode.bottom);
        return dummyNode.bottom;
    }

    static Node flattenLLOptimal(Node head){
        if(head==null || head.next==null){
            return head;
        }
        Node merge=flattenLLOptimal(head.next);
       head=  mergeTwoList(head,merge);
//       displayWithHeadBottom(head);
       return head;
    }
    static Node mergeTwoList(Node head1,Node head2){
        Node dummyNode=new Node(-1);
        Node temp=dummyNode;
        while (head1!=null && head2!=null){
            if(head1.data>head2.data){
                temp.bottom=head2;
                temp=temp.bottom;
                head2=head2.bottom;
            }
            else {
                temp.bottom=head1;
                temp=temp.bottom;
                head1=head1.bottom;
            }
            temp.next=null;
        }
        if(head1!=null){
            temp.bottom=head1;
        }
        else {
            temp.bottom=head2;
        }
        return dummyNode.bottom;
    }

    static void displayWithHeadBottom(Node head){
       Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.bottom;
        }
        System.out.print("END");
    }
}
