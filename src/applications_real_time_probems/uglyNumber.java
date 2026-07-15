package applications_real_time_probems;

import java.util.TreeSet;

public class uglyNumber {
    public static void main(String[] args) {
        System.out.println(uglyNumberTree(12));
    }

    private static boolean isugly(int n) {
        while (n>1){
            if(n%2==0){
               n=n/2;
            } else if (n%3==0) {
                n=n/3;
            } else if (n%5==0) {
                n=n/5;
            }
            else {
                return false;
            }
        }
        return true;
    }
    
    static int nthUglyNumber(int n){
     int count=1;
     int i=1;
     while (n>count){
         i++;
         if(isugly(i)){
            count++;
         }
     }
     return i;
    }

    static int uglyNumberTree(int n){
        TreeSet<Integer> tree=new TreeSet<>();
        tree.add(1);
        int count=1;
        while(n>count){
            int temp=tree.pollFirst();
            tree.add(temp * 2);
            tree.add(temp * 3);
            tree.add(temp * 5);
            count++;
        }
     return tree.pollFirst().intValue();
    }
}
