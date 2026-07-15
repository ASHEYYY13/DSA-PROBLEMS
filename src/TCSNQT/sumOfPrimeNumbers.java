package TCSNQT;

import java.util.Scanner;

public class sumOfPrimeNumbers {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int M=scan.nextInt();
        scan.nextLine();
        int N=scan.nextInt();
        scan.nextLine();
        int sum=0;
        int count=0;
        for (int i = 2; i <=Integer.MAX_VALUE ; i++) {
            if(isPrime(i)){
                count++;
                if(count>=M && count<=M+N) {
                    sum = sum + i;
                    if(count==M+N){
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    private static boolean isPrime(int n) {
        for (int i = 2; i <n ; i++) {
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
}
