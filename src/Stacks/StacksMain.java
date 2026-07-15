package Stacks;

public class StacksMain  {
    public static void main(String[] args) throws StacksExceptions{
        customStacks cs=new customStacks(5);
//        dynamicStacks cs=new dynamicStacks(5);
        cs.push(10);
        cs.push(22);
        cs.push(34);
        cs.push(67);
        cs.push(10);
        cs.push(1000);

        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.pop());
        System.out.println(cs.peek());
    }

}
