package Problems_Topic_Wise.Reccursion_programs;

public class countZeros {
 public  static void main(String[] args) {
	  int n=300201;
	  System.out.println(recursionCount(n,0));
  }
  
  static int count(int n) {
	  int count=0;
	  while(n!=0) {
		  int rem=n%10;
		  if(rem==0) {
			  count++;
		  }
		  n=n/10;
	  }
	  return count;
  }
  static int recursionCount(int n, int c) {
	  if(n==0) {
		  return c;
	  }
	  if(n%10==0) {
		  c++;
	  }
	  return 
			  
			  
			  recursionCount(n/10,c);
  }
  }
