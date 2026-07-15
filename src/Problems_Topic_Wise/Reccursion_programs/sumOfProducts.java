package Problems_Topic_Wise.Reccursion_programs;

public class sumOfProducts {
   public static void main(String[] args) {
	   int n=23322;
	   System.out.println(sumDigits(n));
   }
   static int sumDigits(int n) {
	   if(n<10) {
		   return n;
	   }
	   return (n%10) + sumDigits(n/10);
   }
}
