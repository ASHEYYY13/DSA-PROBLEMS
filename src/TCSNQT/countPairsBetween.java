package TCSNQT;

import java.util.Scanner;

public class countPairsBetween {
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        int T=scanner.nextInt();
        scanner.nextLine();
        while (T-- >0){
            System.out.print("enter the X value");
            long x=scanner.nextLong();
            System.out.print("enter the Y value");
            long y=scanner.nextLong();

            System.out.print("Enter the number of elements in the Array");
            int N=scanner.nextInt();
            scanner.nextLine();

            String[] arr=new String[N];
            for (int i = 0; i <N ; i++) {
                arr[i]=scanner.nextLine();
            }
           int count=0;
            for (int i = 0; i <N ; i++) {
                for (int j = 0; j <N ; j++) {
                    String concat= arr[i]+arr[j];

                    Long val=Long.parseLong(concat);

                    if(val>=x && val<=y){
                        System.out.println(val);
                        count++;
                    }
                }
            }
            System.out.println("count"+count);
        }
        scanner.close();
    }
}
