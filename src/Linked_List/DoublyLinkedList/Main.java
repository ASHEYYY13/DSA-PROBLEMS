package Linked_List.DoublyLinkedList;

public class Main {
    public static void main(String[] args) {
//        DLL list=new DLL();
//         list.insertFirst(10);
//         list.insertFirst(23);
//         list.insertFirst(34);
//        list.insertFirst(13);
//        list.insertFirst(19);
//
//         list.display();
//         list.displayInReverse();


//        LinkedList<Integer> list1=new LinkedList<>();

        DLL list1=new DLL();
        list1.insertLastWithoutTail(10);
        list1.insertLastWithoutTail(20);
        list1.insertLastWithoutTail(30);
        list1.insertLastWithoutTail(40);
        list1.insertLastWithoutTail(50);
        list1.insert(30,35);
        list1.display();
//        list1.displayInReverse();
    }
}
