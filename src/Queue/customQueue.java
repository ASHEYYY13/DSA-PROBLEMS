package Queue;

public class customQueue {
    protected int[] data;
    private static final int SIZE=10;
      int end=0;

    public customQueue() {
        this.data=new int[SIZE];
    }

    public customQueue(int size) {
        this.data=new int[size];
    }
    public boolean isFull(){
        return   end==data.length;
        //when the queue is full
        //when will the queue is full when point is at the last index
    }

    public boolean isEmpty(){
        return end==0;
    }

    public boolean insert(int item){
        if(isFull()){
            return false;
        }
        data[end++]=item;
        return true;
    }

    public int remove() throws Exception{
        if (isEmpty()){
            throw new Exception("Nothing to Remove fuck off");
        }
        int removed=data[0];
        //removing the first element
        for (int i = 1; i <end ; i++) {
            data[i-1]=data[i];
        }
        end--;
        //Shifting one element before its index
        return removed;
    }

    public int front() throws Exception{
        if (isEmpty()){
            throw new Exception("Nothing to Remove fuck off");
        }

        return data[0];
    }

    public void   display(){
        for (int i = 0; i <end ; i++) {
            System.out.print(data[i]+" ");
        }

        System.out.print("END");
    }

}
