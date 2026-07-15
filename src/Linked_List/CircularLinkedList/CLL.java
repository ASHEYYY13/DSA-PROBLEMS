package Linked_List.CircularLinkedList;

public class CLL {
    private Node tail;
    private Node head;
    private int size;

    public CLL() {
        this.size=0;
    }

    public void insert(int value){
        Node node =new Node(value);
        if(head==null){
            head=node;
            tail=node;
            return;
        }
       tail.next=node;
        node.next=head;
        tail=node;
        size+=1;
    }

  public void display(){
       Node node=head;
        if(head!=null){
            do {
                System.out.print(node.value+" ->");
                node=node.next;
            }
            while (node!=head);
            System.out.print("END");
        }
  }

  public void delete(int value){
        Node node=head;
        if(node==null){
            return;
        }
        if(node.value==value){
            head=head.next;
            tail.next=head;
            return;
        }do {
            Node n=node.next;
            if (n.value==value){
                node.next=n.next;
                break;
            }
            node=node.next;
      }    while (node!=head);

  }



    private class Node{
        private int value;

        public Node(int value) {
            this.value = value;
        }

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }

        private Node next;

    }
}
