package Linked_List.DoublyLinkedList;

public class DLL {

    private Node tail;
    private Node head;
    private int size;


    public DLL() {
        this.size=0;
    }

    public void insertFirst(int value){
        Node node=new Node(value);
        node.next=head;
        node.prev=null;

        if(head!=null){
            head.prev=node;
        }

        head=node;
        if(tail==null){
            tail=head;
        }
     size=size+1;
    }

    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node=new Node(value);
        tail.next=node;
        node.prev=tail;
        node.next=null;
        tail=node;

        size=size+1;
    }


    public void insertLastWithoutTail(int value){
        Node Lastnode=head;
        if(head==null){
            insertFirst(value);
            return;
        }
        while (Lastnode.next!=null){
            Lastnode=Lastnode.next;
        }
      Node node=new Node(value);
        Lastnode.next=node;
        node.prev=Lastnode;
        node.next=null;
        tail=node;

        size=size+1;
    }

    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.val==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    public void insert(int value,int insertingValue){
        Node previous=find(value);
        if(previous.next==null){
            insertLast(insertingValue);
        }
        Node node=new Node(insertingValue);
        node.next=previous.next;
        previous.next.prev=node;
        node.prev=previous;
        previous.next=node;
    }

    public void display(){
     Node temp=head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
        System.out.println();
    }
public void displayInReverse(){
        Node temp=tail;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.prev;
        }
    System.out.println();
}


    private class Node{
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(Node next, int val, Node prev) {
            this.next = next;
            this.val = val;
            this.prev = prev;
        }
    }


}
