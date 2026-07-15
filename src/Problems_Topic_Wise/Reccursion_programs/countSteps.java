package Reccursion_programs;

public class countSteps {
   public static void main(String[] args) {
	   int n=8;
	   System.out.println(count(n));
   }
   static int count(int n) {
	   int c=0;
	   return helper(n,c);
   }
 static int helper(int n, int c) {
	 if(n==0) {
		 return c;
	 }
   if(n%2==0) {
	   return helper(n/2,++c);
   }
   else {
	   return helper(n-1,++c);
   }
}
}
