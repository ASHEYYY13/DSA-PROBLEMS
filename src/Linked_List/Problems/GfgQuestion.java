package Linked_List.Problems;

import Linked_List.SingleyLinkedList.linkedlist;

import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

/*
1.intersection of y linked list
2.union of two linked list
3.Delete without head
4.countPairs
5.Detect Loop
6.DeleteLoop
7.Detect Loop's Head
8.CycleLengthWithOutHead
9.Sort012
 */
public class GfgQuestion {
    private  Node head;
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

    static void deleteWithoutHead(Node node){
        node.data=node.next.data;
        node.next=node.next.next;
    }
//this has extra space it works but  not optimal-> Naive Approach
    static Node intersectionOfYLinkedList(Node head1, Node head2){
        HashMap<Node,Integer> map=new HashMap<>();
        Node temp=head1;
        while (temp!=null){
            map.put(temp,temp.data);
            temp=temp.next;
        }
        Node temp2=head2;
        while (temp2!=null){
            if(map.containsKey(temp2)){
                return temp2;
            }
            temp2=temp2.next;
        }
        return null;
    }

    static Node intersectionOfYLinkedListOptimal(Node head1, Node head2){
        if(head1==null || head2==null){
            return null;
        }
     Node temp1=head1;
     Node temp2=head2;

     while (temp1!=temp2){
         temp1=temp1.next;
         temp2= temp2.next;

         if(temp1==temp2){
             return temp1;
         }
         if(temp1==null){
             temp1=head2;
         }
        if(temp2==null){
            temp2=head1;
        }
     }
     return temp1;
    }
//this is better solution without any space but it won't  work it takes too much time;
    static Node intersectionofYLinkedListBetter(Node head1, Node head2){
      Node t1=head1;
      Node t2=head2;
      int  n1=0,n2=0;
      while (t1!=null){
          n1++;
          t1=t1.next;
      }
        while (t2!=null){
            n2++;
            t2=t2.next;
        }
      if(n1>n2){
          return collisionPoint( head1,head2,n1-n2);
      }
      else {
          return collisionPoint(head2, head1,n2-n1);
      }
    }
    static Node collisionPoint(Node head1,Node head2,int length){
        while (length>0){
            length--;
            head1=head1.next;
        }

        while (head1!=head2){
        head1=head1.next;
        head2=head2.next;
        }
        return head1;
    }

   static   void unionOfTwoList(Node head1,Node head2){
        Node temp1=head1;
        Node temp2=head2;
        TreeSet<Integer> set = new TreeSet<>();
        while (temp1!=null){
            set.add(temp1.data);
            temp1=temp1.next;
        }
        while (temp2!=null){
            set.add(temp2.data);
            temp2=temp2.next;
        }
        Node head=null;
        Node temp=head;
        Node tail=null;
         for (int num : set) {
             if(tail==null){
                 Node node=new Node(num);
                 node.next=head;
                 head=node;
                 tail=head;
             }
             Node node=new Node(num);
             tail.next=node;
             tail=node;
         }
      displayWithHead(head.next);
    }
    static void displayWithHead(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }

    public static void main(String[] args) {
        GfgQuestion list1=new GfgQuestion();
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(7);
        list1.add(9);
//        displayWithHead(list1.head);
//      deleteLoop(list1.head);
//      displayWithHead(list1.head);

        GfgQuestion list=new GfgQuestion();
        list.add(10);
        list.add(6);
        list.add(8);

        GfgQuestion list2=new GfgQuestion();
        list2.add(1);
        list2.add(0);
        list2.add(0);
        list2.add(1);
        list2.add(2);
        list2.add(2);
        list2.add(0);
        list2.add(0);
       Node ans= sort123(list2.head);
       displayWithHead(ans);
//        reverseKGroups(list2.head,2);
//         addOne(list.head);
//        intersectionofYLinkedListBetter(list1.head,list.head);
//        unionOfTwoList(list1.head,list.head);
//        deleteWithoutHead(list2.head.next);
//        displayWithHead(list2.head);
//        System.out.println(countPair(list.head,list1.head,13));
    }


    public static int countPair(Node head1 ,Node head2,int x){
        HashSet<Integer> map=new HashSet<>();
        Node temp=head1;
        while (temp!=null){
            map.add(temp.data);
            temp=temp.next;
        }
        int  count=0;
        Node temp2=head2;
        while (temp2!=null){
            int y=x-temp2.data;
            if(map.contains(y)){
                count++;
            }
            temp2=temp2.next;
        }
        return count;
    }

    public static Node reverseKGroups(Node head,int k){
        if(k<=0 || head==null || head.next==null){
            return head;
        }
        Node temp=head;
        Node prev=null;

        while (temp!=null){
           Node newEnd=temp;
           Node last=prev;

            for (int i = 0;temp!=null && i <k ; i++) {
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
        displayWithHead(head);
        return head;

    }
    public static boolean detectLoop(Node head) {
        Node fast=head;
        Node slow=head;
        if(fast==null && fast.next==null){
            return false;
        }

        while (fast!=null && fast.next!=null ){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                return true;
            }
        }
      return false;
    }

    public  static Node cycleHeadNext(Node head){
        int length=0;
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(slow==fast){
               length=cycleLengthWihCyclePointer(slow);
               break;
            }
        }
        if(length==0){
            return null;
        }
        Node first=head;
        Node second=head;

        while (length>0){
            first=first.next;
            length--;
        }

        while (first!=second){
            second=second.next;
            first=first.next;
        }
        return first;
    }
    public static  void deleteLoop(Node head){
        int length=0;
        Node slow=head;
        Node fast=head;

        while (fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;

            if(slow==fast){
                length=cycleLengthWihCyclePointer(slow);
                break;
            }
        }
        if(length==0){
            return;
        }

        Node prev=null;
        Node first=head;
        Node second=head;

        while (length>0){
            prev=first;
            first=first.next;
            length--;
        }

        while (first!=second){
            prev=first;
            second=second.next;
            first=first.next;
        }
        prev.next=null;
    }
    public static int cycleLengthWihCyclePointer(Node node){
      Node slow=node;
      Node temp=node;
      int length=0;
      if(temp==null && temp.next==null){
          return 0;
      }
      do{
          temp=temp.next;
          length++;
      }while (temp!=slow);
      return length;
    }


    public static Node sort123(Node head){
        Node temp=head;
        int count0=0;
        int count1=0;
        int count2=0;
        while (temp!=null){
            if(temp.data==0){
                count0++;
            }
            else if(temp.data==1){
                count1++;
            }
            else {
                count2++;
            }
            temp=temp.next;
        }

        Node temp1=head;
        while (temp1!=null){
            if(count0>0){
                temp1.data=0;
                count0--;
            }
            else if(count1>0){
                temp1.data=1;
                count1--;
            }
            else {
                temp1.data=2;
                count2--;
            }
            temp1=temp1.next;
        }
        return head;
    }
}
