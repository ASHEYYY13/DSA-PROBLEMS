package BasicProblems;

public class LastDigit {
    public int getLastDigit(String a,String b){

        // a^0 = 1
        if (b.equals("0"))
            return 1;

        int lastDigit = a.charAt(a.length() - 1) - '0';

        // Calculate b % 4 from the string
        int mod = 0;
        for (int i = 0; i < b.length(); i++) {
            mod = (mod * 10 + (b.charAt(i) - '0')) % 4;
        }

        if (mod == 0)
            mod = 4;

        int result = 1;
        for (int i = 0; i < mod; i++) {
            result *= lastDigit;
        }

        return result % 10;
    }
}
