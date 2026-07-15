package Linked_List.Problems;

import java.util.Stack;


/*
1.isK eyThere->finding specific node is there are not
2.ReverseLL
3.ReverseLL Recursion
4.isPalindrome
5.HasCycle,DetectCycle,cycleLength,DetectCycle"s head
6.isHappy
7.reverseSpecific ->reverse partial linked list
 */
public class findElement {

private static Node head;
 static Node tail;
  static int size;

    public static int getSize() {
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

        size+=1;
    }
     void insertMiddle(Node head,int x){
        Node slow=head;
        Node fast=head;
        Node temp=head;
         Node node=new Node(x);
         if(temp==null){
             temp=node;
             temp.next=null;
//             return temp;
         }
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        node.next=slow.next;
        slow.next=node;
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
  class Node {
    private   Node next;
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
//        LinkedList<Integer> list=new LinkedList<>();
        findElement list = new findElement();
        list.add(1);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(10);
//        list.display();
//        list.insertMiddle(list.head,20);
//        System.out.println();
//        list.display();
//        System.out.println(isKeyThere(getSize(),6,list));
//        reverse(head);
//        displayInReverse(head);
//        displayInReverse(reverseRecursive(head,null));
//        System.out.println(isPalindrome(list.head));
//        System.out.println(hasCycle(list.head));
        reverseSpecific(list.head,2,4);
    }

 public static boolean isKeyThere(int size,int key,findElement list){
        Node node=head;
        for (int i = 0; i < size; i++) {
            if(node.data==key){
                return true;
            }
            node=node.next;
        }
        return false;
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
//     displayInReverse(previous);
     return previous;
    }

     static Node reverseSpecific(Node head,int left,int right){
        displayInReverse(head);
        if (left==right){
            return head;
        }
        Node temp=head;
        Node previous=null;

        for (int i = 0; temp!=null &&i <left-1 ; i++) {
             previous=temp;
             temp=temp.next;
        }

        Node last=previous;
        Node newEnd=temp;
         for (int i = 0; temp!=null && i <right-left+1 ; i++) {
             Node front = temp.next;
             temp.next=previous;
             previous=temp;
             temp=front;
         }
         if(last!=null){
             last.next=previous;
         }
         else {
             head=previous;
         }
         newEnd.next=temp;

     displayInReverse(head);
        return head;
    }


    public  static Node reverseRecursive(Node head,Node previous){
        Node temp=head;
        if(temp==null){
            return previous;
        }
        Node front = temp.next;
        temp.next=previous;
      return reverseRecursive(front,temp);

    }

    public  static void  reverseRecursiveAnother(Node node){
      if(node==tail){
          head=node;
          return;
      }
      reverseRecursiveAnother(node.next);
      tail.next=node;
      tail=node;
      tail.next=null;
    }

    static void displayInReverse(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }

    static boolean isPalindrome(Node head){
        Node slow=head;
        Node fast=head;
        while (fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        Node temp=head;
        Node reverse=reverse(slow);
//        Node temp1=reverse;
        while (temp!=null && reverse!=null){
            if(reverse.data==temp.data){
                reverse=reverse.next;
                temp=temp.next;
            }
            else {
                return false;
            }
        }
        return true;
    }
    static boolean isPalindromeNaiveApproach(Node head){
        Stack<Integer> st =new Stack<>();
        Node temp=head;
        while (temp!=null){
            st.push(temp.data);
            temp=temp.next;
        }
        Node node=head;
        while (node!=null){
            if(node.data==st.peek()){
                st.pop();
                node=node.next;
            }
            else {
                return false;
            }
        }
        return true;
    }
    // linked list life cycle question using slow and fast pointers
  static boolean hasCycle(Node head) {
        Node slow=head;
        Node fast=head;
        if(slow==null){
            return false;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }

    static Node detectCycle(Node head){
        int length=0;
        Node slow=head;
        Node fast=head;
        if(slow==null){
            return null;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
               length=cycleLength(slow);
               break;
            }
        }
        Node first=head;
        Node second=head;
        while (length>0){
            second=second.next;
            length--;
        }
        while (first!=second){
            second=second.next;
            first=first.next;
        }

        return first;
    }

    static int cycleLength(Node head) {
        Node slow=head;
        Node fast=head;
        if(slow==null){
            return 0;
        }
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                Node temp=slow;
                int length=0;
              do{
                  temp=temp.next;
                  length++;
              }while (temp!=slow);
                    return length;
            }
        }
        return 0;
    }

    public boolean ishappy(int num){
        int slow=num;
        int fast=num;
    do{
        slow=findsquareSum(slow);
        fast=findsquareSum(findsquareSum(fast));
    }while (slow!=fast);

    if(slow==1){
        return true;
    }
    return false;

    }
   private int findsquareSum(int num){
        int ans=0;
       while (num>0){
           int rem=num%10;
           rem=rem*rem;
           ans=ans+rem;
           num=num/10;
       }
       return ans;
   }
}
