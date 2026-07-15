package Linked_List.Problems;


import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeSet;

/*
1.pair swap in the linked list
2.Merge Two Sorted  List
3.Sort LL using Merge Sort
3.Remove Duplicates from Sorted LL
4.Remove Duplicates from Unsorted LL
5.Remove Duplicates and Sort the LL (its done by accident the question was only remove duplicates from the Unsorted LL but i did sort
using TreeSet )
6.Add 1 to the LL
7.Add two numbers in the two linked list
8.segregate odd and even number in the LL
9.subtraction of LL
 */
public class GFGQuestions2 {
    private static Node current;
    private Node head;
    private Node tail;
    int size;

    public  int getSize() {
        return size;
    }

    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        head=node;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    public void add(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node =new Node(value);
        tail.next=node;
        tail=node;
//        tail.next=head.next;

        size+=1;
    }

    public void display(){
       Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
//        System.out.print("END");
//        System.out.println();
    }
    static class Node {
        private Node next;
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
       GFGQuestions2 list=new GFGQuestions2();
       list.add(5);
       list.add(2);
       list.add(6);
       list.add(3);
       list.add(3);
       list.add(4);
       list.add(6);
       list.add(5);
       list.add(10);
       list.add(4);
       list.add(4);

        GFGQuestions2 list2=new GFGQuestions2();
//        pairwiseSwap(list.head);
//        list2.add(5);
//        list2.add(6);
//        list2.add(3);
//        list2.add(1);
//        list2.add(9);
        list2.add(5);
        GFGQuestions2 list1=new GFGQuestions2();
        list1.add(5);
//        list1.add(2);
//        list1.add(0);
//        list1.add(5);
//        list1.add(0);
//       Node ans=pairwiseSwap(list.head);
//        Node ans=mergeTwoList(list.head,list2.head);
//        Node ans=sortList(list.head);
//        Node ans=RemoveDuplicates(list.head);
//        Node ans=RemoveDuplicatesUnSorted(list.head);
//        Node ans=Add1(list2.head);
        Node ans=subLinkedList(list2.head,list1.head);
       displayWithHead(ans);

    }

    private static Node pairwiseSwap(Node head) {
        Node temp=head;
        Node prev=null;
        while (temp!=null){
           Node newEnd=temp;
            Node last=prev;

            for (int i = 0;temp!=null && i <2; i++) {
               Node front =temp.next;
                temp.next = prev;
                prev = temp;
                temp = front;
            }
            if (last != null) {
                last.next = prev;
            } else {
                head = prev;
            }
            newEnd.next=temp;
            if (temp==null){
                break;
            }

            prev=newEnd;
        }
        return head;
    }


    static Node mergeTwoList(Node head1,Node head2){
        Node ans=new Node(10);
        Node tail=ans;
        while (head1!=null && head2!=null){
            if(head1.data<head2.data){
                tail.next=head1;
                head1=head1.next;
                tail=tail.next;
            }
            else {
                tail.next=head2;
                head2=head2.next;
                tail=tail.next;
            }
        }
        while (head1!=null){
            tail.next=head1;
            head1=head1.next;
            tail=tail.next;
        }
       while (head2!=null){
           tail.next=head2;
           head2=head2.next;
           tail=tail.next;
       }
       return ans.next;
    }



    static void displayWithHead(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }


    public static Node sortList(Node head) {
        if(head==null || head.next==null){
            return head;
        }
      Node mid=middleNode(head);
        Node rightHead=mid.next;
        mid.next=null;
        Node leftHead=head;
     leftHead=sortList(leftHead);
        rightHead=sortList(rightHead);

        return mergeTwoList(leftHead,rightHead);


    }
    static public Node middleNode(Node head) {
        Node slow=head;
       Node fast=head.next;
        if(fast==null){
            return fast;
        }
        while( fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

//    static Node QuickSort(Node head){
//
//    }

    public static Node RemoveDuplicates(Node head){
       Node temp=head;
        while (temp.next!=null){
            if( temp.data==temp.next.data){
                temp.next=temp.next.next;
            }
            else {
                temp=temp.next;
            }
        }
       return head;
    }
    public static void RemoveDuplicatesTotally(Node head){
        Node temp=head;
        Node tempNext=head;
        while(tempNext.next!=null){
            if(tempNext.data==tempNext.next.data){
                tempNext.next=tempNext.next.next;
            }
            else {

            }
        }

    }

    public static Node RemoveDuplicatesUnSortedLL(Node head){
        if(head==null || head.next==null){
            return head;
        }
        TreeSet<Integer> set=new TreeSet<>();
        Node temp=head;
        while (temp!=null){
            set.add(temp.data);
            temp=temp.next;
        }
        Node temp2=new Node(-1);
        Node tail=temp2;
        while (!set.isEmpty()) {
            tail.next=new Node(set.getFirst());
            set.removeFirst();
            tail=tail.next;
        }
        return temp2.next;
    }

    public static Node RemoveDuplicatesUnSorted(Node head){
        if(head==null || head.next==null){
            return head;
        }
        HashSet<Integer> set=new HashSet<>();
        Node prev=null;
        Node current =head;
        while (current!=null){
            if(set.contains(current.data)){
                prev.next=current.next;
            }
            else{
                set.add(current.data);
                prev=current;
            }
            current=current.next;
        }
        return head;
    }

    static Node Add1(Node head){
       int carry=helper(head);
       if(carry==1){
           Node newHead=new Node(1);
           newHead.next=head;
           return newHead;
       }
       return head;
    }

    private static int helper(Node head) {
        if (head==null){
            return 1;
        }

        int carry=helper(head.next);
        head.data=head.data+carry;
        if(head.data<10){
            return 0;
        }
        head.data=0;
        return 1;
    }

    static Node AddTwoNumbers(Node head,Node head2){
        Node temp1=reverse(head);
        Node temp2=reverse(head2);
        int carry=0;
        Node newHead=null;
        Node newTail=null;

        while (temp1!=null && temp2!=null){
            int num= temp1.data+ temp2.data+carry;
            Node node=new Node(num);
            node.next=newHead;
            newHead=node;
            if(newTail==null){
                newTail=node;
            }
            if(node.data<10){
                carry=0;
                temp1=temp1.next;
                temp2=temp2.next;
                continue;
            }
            node.data=num%10;
            carry=1;
            temp1=temp1.next;
            temp2=temp2.next;
        }

        while (temp1!=null){
            Node node=new Node(temp1.data+carry);
            node.next=newHead;
            newHead=node;
            if(newTail==null){
                newTail=node;
            }
            if(node.data<10){
                temp1=temp1.next;
                carry=0;
                continue;
            }
            node.data=0;
            carry=1;
            temp1=temp1.next;
        }

        while (temp2!=null){
            Node node=new Node(temp2.data+carry);
            node.next=newHead;
            newHead=node;
            if(newTail==null){
                newTail=node;
            }
            if(node.data<10){
                carry=0;
                temp2=temp2.next;
                continue;
            }
            node.data=0;
            carry=1;
            temp2=temp2.next;
        }
        if(carry==1){
            Node node=new Node(1);
            node.next=newHead;
            newHead=node;
        }
       return newHead;
    }


    public  static Node reverse(Node head){
        Node temp=head;
        Node previous=null;
        while (temp!=null){
            Node front = temp.next;
            temp.next=previous;
            previous=temp;
            temp=front;
        }
        return previous;
    }

    static Node  segregate(Node head){
        Queue<Integer> odd=new LinkedList<>();
        Queue<Integer> even=new LinkedList<>();
        Node temp=head;

        while (temp!=null){
           if(temp.data%2==0){
               even.add(temp.data);
               temp=temp.next;
           }
           else {
               odd.add(temp.data);
               temp=temp.next;
           }
        }

        Node node=head;
        while (!even.isEmpty()){
            node.data=even.poll();
            node=node.next;
        }
        while (!odd.isEmpty()){
            node.data=odd.poll();
            node=node.next;
        }
        return head;
    }

    static Node subLinkedList(Node head1, Node head2) {
        Node temp1=null;
        Node temp2=null;
        if(getLargest(head1,head2)==head2){
            temp1=reverse(head2);
            temp2=reverse(head1);
        }
        else {
            temp1=reverse(head1);
            temp2=reverse(head2);
        }

        int carry=0;
        Node newHead=null;
        Node newTail=null;
        while (temp1!=null && temp2!=null){
            int num=temp1.data- temp2.data-carry;
            if(num<0){
                num= temp1.data+10- temp2.data-carry;
                carry=1;
            }
            else{
                carry=0;
            }
            Node node=new Node(num);
            node.next=newHead;
            newHead=node;
            if(newTail==null){
                newTail=node;
            }
            temp1=temp1.next;
            temp2=temp2.next;

        }

        while (temp1!=null){
            int num=temp1.data-carry;
            if(num<0){
                num= temp1.data+10-carry;
                carry=1;
            }
            else {
                carry=0;
            }
            Node node=new Node(num);
            node.next=newHead;
            newHead=node;
            if(newTail==null){
                newTail=node;
            }
            temp1=temp1.next;
//            temp2=temp2.next;
        }

        while (newHead.data==0){
            if(newHead.next!=null) {
                newHead = newHead.next;
                continue;
            }
            break;
        }
        return newHead;
    }

    static Node getLargest(Node head1,Node head2){
        Node l1=head1;
        Node l2=head2;
        while(l1!=null && l2!=null){
            l1 = l1.next;
            l2 = l2.next;
        }
        if(l2==null && l1==null){
            return biggerInNumber(head1,head2);
        }
        if(l1==null){
            return head2;
        }
        else {
            return head1;
        }
    }

    private static Node biggerInNumber(Node head1, Node head2) {
        Node l1=head1;
        Node l2=head2;
        while (l1!=null && l2!=null){
            if(l1.data>l2.data){
                return head1;
            }
            else if(l2.data>l1.data){
                return head2;
            }
          l1=l1.next;
            l2=l2.next;
        }
       return head1;
    }

    static int getLength(Node head){
        Node temp=head;
        int size=0;
        while (temp!=null){
            temp=temp.next;
            size++;
        }
        return size;
    }

}
