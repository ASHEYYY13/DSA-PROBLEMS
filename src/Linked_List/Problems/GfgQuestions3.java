package Linked_List.Problems;

public class GfgQuestions3 {
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

    public void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
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
      GfgQuestions3 list1=new GfgQuestions3();
      list1.add(2);//2 8 4 4 9 6 6
      list1.add(8);
      list1.add(4);
      list1.add(4);
      list1.add(9);
      list1.add(6);
      list1.add(6);
//      displayWithHead(list1.head);
//      reorderList(list1.head);
//        System.out.println();
//      displayWithHead(list1.head);
//        Node ans=deleteNodeGreaterToRight(list1.head);
//        displayWithHead(ans);
        deleteNNodesAfterMNodes(list1.head,1,2);

    }

    static void displayWithHead(Node head){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
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

    static void reorderList(Node head){
          Node newHead=head;
          Node mid=middleNode(head);
          Node reverseHead=reverse(mid);
          while (newHead!=null && reverseHead!=null){
              Node temp=newHead.next;
              newHead.next=reverseHead;
              newHead=temp;
              temp=reverseHead.next;
              reverseHead.next=newHead;
              reverseHead=temp;
          }
          if(newHead!=null){
              newHead.next=null;
          }
    }
    static Node middleNode(Node head) {
        Node slow=head;
        Node fast=head;
        if(fast==null){
            return null;
        }
        while (fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;

        }
        return slow;
    }

    static Node deleteNodeGreaterToRight(Node head){
        Node dummyNode=new Node(-1);
        Node prev=dummyNode;
       Node curr=head;
        Node next=head.next;

        while (curr.next!=null){
            if(curr.data<next.data){
                curr=curr.next;
                if(curr.next!=null) {
                    next = curr.next;
                }
            }
            else {

               prev.next=curr;
                prev=prev.next;

                curr=curr.next;
                next=next.next;
            }
        }
       prev.next=curr;
        return dummyNode.next;

    }
  static Node deleteNNodesAfterMNodes(Node head,int n,int m){
      Node temp=head;
      Node next=head.next;
      while(next!=null){
          for(int i=1;i<m && next!=null;i++){
              temp=temp.next;
              next=next.next;
          }

          for(int j=1;j<n && next!=null;j++){
              next=next.next;
          }
          if(next!=null) {
              temp.next = next.next;
              temp=temp.next;
              next=temp.next;
          }
      }
      displayWithHead(head);
      return head;
  }
}
