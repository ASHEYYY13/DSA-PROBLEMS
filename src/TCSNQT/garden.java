package TCSNQT;

import java.util.Scanner;

public class garden {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        int n=4;
        int[] arr=new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scan.nextInt();
            if (arr[i] < 0) {
                System.out.println("Not Valid Input");
                return;
            }
        }
          int diff=helper(arr);
          if(diff==0){
              System.out.println("None");
          }
          else {
              System.out.println(diff);
          }
    }
    private static int helper(int[] arr){
        int diff=0;
        if(arr[1]-arr[0]==arr[2]-arr[1]){
            diff=arr[1]-arr[0];
        }

        if(arr[3]-arr[2]==arr[1]-arr[0]){
            diff=arr[1]-arr[0];
        }

        if(arr[3]-arr[2]==arr[2]-arr[1]){
            diff=arr[1]-arr[0];
        }
       return diff ;
    }
}
