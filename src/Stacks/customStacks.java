package Stacks;

public class customStacks {
    protected int[] data;
    private static final int SIZE=10;
     int ptr=-1;
    public customStacks() {
        this.data=new int[SIZE];
    }

    public customStacks(int size) {
      this.data=new int[size];
    }

    public int pop(){
        if (isEmpty()){
            System.out.println("Nothng in the stack");
            return -1;
        }

        int Last=data[ptr];
        ptr--;
        return Last;
    }

    public boolean push(int item){
        if (isFull()){
            System.out.println("Stack is full poitu vango");
            return false;
        }
        ptr++;
        data[ptr]=item;
        return true;
    }
    public int peek() throws StacksExceptions{
        if (isEmpty()){
            throw new StacksExceptions("Stack is full poitu vango");
        }
        return data[ptr];
    }
 public boolean isFull(){
        return ptr==data.length-1;
        //when the stack is full
     //when will the stack is full when point is at the last index
 }

 public boolean isEmpty(){
        return ptr==-1;
 }


}
