package Linked_List.SingleyLinkedList;



/*
Metthods used in this class
1.insertfirst,insertspecific index,insertLast,InsertUsingRecursion
2.getSize,display
3.Delete,DeleteFirst,DeleteLast,
4.find
 */
public class linkedlist {

    private Node head;
    private Node tail;
    private int size;

    public linkedlist() {
        this.size=0;
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

    public  void insert(int value,int index){
    if(index==size){
        insertLast(value);
        return;
    }
    if (index==0){
        insertFirst(value);
        return;
    }
    Node temp=head;
        for (int i = 1; i <index ; i++) {
            temp=temp.next;
        }
        Node node=new Node(temp.next,value);
        temp.next=node;
    }

    public void insertLast(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        Node node =new Node(value);
       tail.next=node;
       tail=node;

        size+=1;
    }

    public void insertRecursion(int value ,int index){
        Node temp=head;
        recursive(temp,value,index-1);
    }
    private void recursive(Node node, int value, int index){
        if(index==0){
         Node temp=new Node(value);
        temp.next=node.next;
        node.next=temp;
         size++;
//this is not totally correct
        return;
        }
        recursive(node.next,value,index-1);

      
    }

    public void display(){
        Node temp=head;
        while (temp!=null){
            System.out.print(temp.value+" -> ");
            temp=temp.next;
        }
//        System.out.print("END");
//        System.out.println();
    }

    public int getSize() {
        return size;
    }
    public Node get(int index){
        Node node=head;
        for (int i = 0; i <index ; i++) {
            node=node.next;
        }
        return node;

    }

    public int deleteLast(){
        if(size<=1){
            return deleteFirst();
        }
        Node secondLast=get(size-2);
        int value= tail.value;
        tail=secondLast;
        tail.next=null;
        size-=1;
         return value;
    }

    public int deleteFirst(){
        int value=head.value;
        head=head.next;
        if(head==null){
            tail=null;
        }
        size-=1;
        return value;
    }

    public int delete(int index){
        if(index==0){
            return deleteFirst();
        }
        if(index==size-1){
            return deleteLast();
        }
       Node beforeNode=get(index-1);
        int value=beforeNode.next.value;
        beforeNode.next=beforeNode.next.next;
//        beforeNode.next=temp;
        size-=1;
        return value;


    }
    public Node find(int value){
        Node node=head;
        while(node!=null){
            if(node.value==value){
                return node;
            }
            node=node.next;
        }
        return null;
    }

    private class Node{
          private Node next;
          private int value;

       public Node(int value) {
           this.value = value;
       }

       public Node(Node next, int value) {
           this.next = next;
           this.value = value;
       }
   }
}
