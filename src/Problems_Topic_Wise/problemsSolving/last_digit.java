package Problems_Topic_Wise.problemsSolving;

public class last_digit {
  public static void main(String[] args) {
	  String a="3";
	  String b="12";
	  int c=153;
//	  System.out.println(lastDigit(a,b));
	  System.out.println(armstrongNumber(c));
  }

static int lastDigit(String a, String b) {
	
    int c =Integer.parseInt(a);
    int d =Integer.parseInt(b);
   int num = (int) Math.pow(c, d);
    return num%10;
    }

static int countdigit(int a ) {
	int count=0;
	int og=a;
	while(a>0) {
		
		int n=a%10;
		if(n!=0 && og%n==0) {
			count ++;
		}
		a=a/10;
	}
	return count;
	
}
static int reverseDigits(int n) {
int 	reversed=0;
	while(n!=0) {
		int a=n%10;
		reversed = reversed*10+a;
		 n=n/10;
	}
return reversed;
}
static int armstrongNumber(int n) {
    int arms=0;
    while(n!=0){
        int a =n%10;
        arms=arms+(a*a*a);
        n=n/10;
    }
    return arms;
}
}

