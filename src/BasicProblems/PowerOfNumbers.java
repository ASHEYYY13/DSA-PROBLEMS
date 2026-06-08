package BasicProblems;

public class PowerOfNumbers {
    public static  int reverseExponentiation(int n) {

        int reverse=ReverseDigits.reverseDigits(n);
        int ans=1;
        for(int i=0;i<reverse;i++){
            ans*=n;
        }

        return ans;
    }
}
