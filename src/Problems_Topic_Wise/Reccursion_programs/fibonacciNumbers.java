package Problems_Topic_Wise.Reccursion_programs;

public class fibonacciNumbers {
    public static void main(String[] args) {
    	int ans =fibo(5);
    	System.out.println(ans);
    }
   static int fibo(int n) {
     return (int) ((Math.pow(((1+Math.sqrt(5))/2),n))/Math.sqrt(5));
   }
}
