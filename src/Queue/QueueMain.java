package Queue;

public class QueueMain {
    public static void main(String[] args) throws Exception {
//        customQueue queue=new customQueue(5);
        circularQueue queue=new circularQueue(6);
      queue.insert(10);
      queue.insert(20);
      queue.insert(55);
      queue.insert(45);
      queue.insert(67);

//        System.out.println(queue.remove());
//        System.out.println(queue.remove());
//        System.out.println(queue.remove());

        queue.insert(90);
        queue.remove();
        queue.remove();
        queue.insert(999);
//        queue.insert(99);
//        queue.insert(78);

        DynamicQueue qu=new DynamicQueue(4);
        qu.insert(1);
        qu.insert(2);
        qu.insert(3);
        qu.insert(4);
        qu.insert(5);
        qu.insert(100);
        qu.display();

//      queue.display();
    }

}
