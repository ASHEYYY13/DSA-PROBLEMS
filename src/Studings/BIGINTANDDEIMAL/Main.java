package Studings.Strings.BIGINTANDDEIMAL;
import java.math.BigDecimal;
import  java.math.BigInteger;
public class Main {
    public static void main(String[] args) {

        BigInteger b= new BigInteger("45654555455985667844");
        BigInteger c= new BigInteger("45654555455985667844");
        System.out.println(b.add(c));

//        System.out.println(factorial.fact(344323));
        BD();

    }
    static  void BD(){
        double x=0.01;
        double y=0.03;
        System.out.println(x-y);

        BigDecimal X=BigDecimal.valueOf(0.01);
        BigDecimal Y=BigDecimal.valueOf(0.03);
        System.out.println(X.subtract(Y));
    }
}
