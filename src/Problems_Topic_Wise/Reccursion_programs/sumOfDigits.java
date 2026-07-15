package Problems_Topic_Wise.Reccursion_programs;

public class sumOfDigits {
   public static void main(String[] args) {
	   int n=23322;
	   System.out.println(productsDigits(n));
   }
   static int productsDigits(int n) {
	   if(n<10) {
		   return n;
	   }
	   return (n%10) * productsDigits(n/10);
   }
}
