package BasicProblems;

public class ReverseDigits {
    public static int reverseDigits(int n) {

        int ans=0;
        while (n>0){
            ans=ans*10;
            int lastDigit=n%10;
             n=n/10;

           ans+=lastDigit;
        }

        return ans;
    }
}
