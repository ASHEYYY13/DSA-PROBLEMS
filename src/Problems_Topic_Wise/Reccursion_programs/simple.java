package Reccursion_programs;

public class simple {
    public static void main(String[] args) {
         msg();
    }
    static void msg() {
    	System.out.println("Hello Man ");
    	msg1();
    }
    static void msg1() {
    	System.out.println("Hello Man ");
    	msg2();
    }
    static void msg2() {
    	System.out.println("Hello Man ");
    	msg3();
    }
    static void msg3() {
    	System.out.println("Hello Man ");
    	msg4();
    }
    static void msg4() {
    	System.out.println("Hello Man ");
    }
}
