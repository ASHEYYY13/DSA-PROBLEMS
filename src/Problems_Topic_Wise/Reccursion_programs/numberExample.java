package Reccursion_programs;

public class numberExample {
  public static void main(String[] args) {
	  printNumber(1);
}
  static void printNumber(int n) {
	  System.out.println(n);
	 
	 if(n<5) {
		 printNumber(n+1);
		 
	 }
  }
}
