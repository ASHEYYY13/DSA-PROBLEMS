package Queue;

public class circularQueue {
    protected int[] data;
    private static final int SIZE=10;
    int front=0;
    int size=0;
    int end=0;

    public circularQueue() {
        this.data=new int[SIZE];
    }

    public circularQueue(int size) {
        this.data=new int[size];
    }
    public boolean isFull(){
        return   size==data.length;
        //when the queue is full
        //when will the queue is full when point is at the last index
    }

    public boolean isEmpty(){
        return size==0;
    }


    public boolean insert(int item) throws Exception{
        if (isFull()){
            throw new Exception("Queue is full");
        }
        data[end++]=item;
        size++;
        end=end%data.length;
        return true;
}
 public int remove() throws Exception{
        if(isEmpty()){
            throw new Exception("Queue is full");
        }

        int removed=data[front++];
        front=front%data.length;
        size--;
        return removed;
 }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Nothing to Remove fuck off");
        }

        return data[front];
    }


    public void   display(){
       if(isEmpty()){
           System.out.println("Queue is Empty");
           return;
       }
       int i=front;
       do{
           System.out.print(data[i]+ " ");
           i++;
           i%=data.length;
       }
       while (i!=end);
    }
}
