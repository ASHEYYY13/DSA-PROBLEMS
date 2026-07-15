package matrixProoblems;

public class Random {
    public static void main(String[] args) {
        printZ("zohoCorporationteam");
    }

    static void printZ(String input){
        System.out.println(input.length());
        int size=input.length();
        int up=size/3;
        int cross=up-1;
        int down=up;

        for (int i = 0; i <=up; i++) {
            System.out.print(input.charAt(i)+" ");
        }
        System.out.println();
        for (int i = 0; i <=cross ; i++) {
            for (int j = 1; j <=up-i-1 ; j++) {
                System.out.print("  ");
            }
            System.out.print(input.charAt(up+i+1));
            if(i!=cross) {
                System.out.println();
            }
        }
        for (int i = 1; i <=down ; i++) {
            System.out.print(" "+ input.charAt(up+cross+i+1));
        }
    }
}
