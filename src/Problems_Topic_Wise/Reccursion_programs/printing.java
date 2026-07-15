package Reccursion_programs;

public class printing {
 public static void main(String[] args) {
	 int n=5;
//	 printNto1(n);
	 print1toN(10);
 }
 static void printNto1(int n) {
	 
	 if(n==1) {
		 System.out.println(n);
		 return;
	 }
	
	 System.out.println(n);
	 printNto1(n-1);
	 
 }
 static void print1toN(int n) {
	 
	 if(n==1) {
		 System.out.println(n);
		 return;
	 }
	 print1toN(n-1);
	 System.out.println(n);

	 
 }
}
