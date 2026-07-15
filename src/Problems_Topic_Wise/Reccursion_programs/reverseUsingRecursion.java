package Problems_Topic_Wise.Reccursion_programs;

public class reverseUsingRecursion {

	static int sum=0;
static void reverse1(int n) {
	if(n==0) {
		return ;
	}
	int r=n%10;
	sum=sum*10+r;
	reverse1(n/10);//this more like the normal way like using while loop
}


static int reverse2(int n) {
 
	int digits=(int)(Math.log10(n)) + 1;
	return helper(n,digits);
}

static int helper(int n,int dig) {
	if(n<10) {
		return n;
	
	}
	
	return n%10*(int)(Math.pow(10,dig-1)) + helper(n/10,dig-1);
}

static boolean palin(int n) {
	return (n==reverse2(n));
}
public static void main(String[] args) {


System.out.println(palin( 1221));
}
}
