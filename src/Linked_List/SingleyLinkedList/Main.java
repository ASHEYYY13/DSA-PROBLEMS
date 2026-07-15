package Linked_List.SingleyLinkedList;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        linkedlist list=new linkedlist();
       list.insertFirst(1);
        list.insertFirst(17);
        list.insertFirst(4);
        list.insertFirst(8);
        list.insertFirst(67);

//        list.display();


        LinkedList<Integer> list1=new LinkedList<>();
        list1.add(12);
        list1.add(32);
        list1.add(36);
        list1.offer(67);
        list1.add(78);
        list.display();
        System.out.println( );
//        System.out.println(list1);



        linkedlist list2=new linkedlist();
        list2.insertLast(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(4);
        list2.insertLast(5);
        list2.insert(10,3);
//        list2.display();
//        list2.insertRecursion(28,3);
     System.out.println();
        list2.display();
//     System.out.println();
//     System.out.println(list2.deleteFirst());
//     list2.display();
//     System.out.println();
//     System.out.println(list2.deleteLast());
//     list2.display();
//     System.out.println(list.getSize());
//     System.out.println("List2's size  "+list2.getSize());
//     System.out.println();
//     System.out.println(list2.delete(2));
//     list2.display();
    }
}
