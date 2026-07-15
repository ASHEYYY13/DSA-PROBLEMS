package Reccursion_programs;

public class sumofNumbers {
   public static void main(String[] args) {
	   int n=5;
	   System.out.println(Sum(n));
   }
   static int Sum(int n) {
	   if(n==1) {
		   return 1;
	   }
	   
	   return n+Sum(n-1);
   }
}
