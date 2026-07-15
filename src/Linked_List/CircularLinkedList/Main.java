package Linked_List.CircularLinkedList;

public class Main {
    public static void main(String[] args) {
        CLL list=new CLL();
        list.insert(10);
        list.insert(32);
        list.insert(45);
        list.insert(65);
      list.display();
      list.delete(32);
        System.out.println();
      list.display();
      list.delete(65);
        System.out.println();
      list.display();
    }
}
