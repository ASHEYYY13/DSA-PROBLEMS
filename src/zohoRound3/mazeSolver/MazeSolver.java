package zohoRound3.mazeSolver;

import java.util.Scanner;

public class MazeSolver {

    static Scanner scanner=new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Enter the size of the  matrix (n*n)");
        int n=scanner.nextInt();

        System.out.println("Enter the Adventurer location:");
        int AdRow=scanner.nextInt();
        int AdCol=scanner.nextInt();

        System.out.println("Enter the Destination location:");
        int DesRow=scanner.nextInt();
        int DesCol=scanner.nextInt();

        initilizeMatrix(n,AdRow,AdCol,DesRow,DesCol);

    }

    private static void initilizeMatrix(int n, int adRow, int adCol, int desRow, int desCol) {
        char[][] matrix=new char[n][n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i==adRow && j==adCol){
                    matrix[i][j]='A';
                    continue;
                }
                if(i==desRow && j==desCol){
                    matrix[i][j]='D';
                    continue;
                }
                matrix[i][j]='0';
            }
        }


        //print matrix
        System.out.println("MATRIX");
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print(matrix[i][j]+ " ");
            }
            System.out.println();
        }
        System.out.println("The Shortest path is : "+findShortestPath(adRow,adCol,desRow,desCol));
    }

    private static int findShortestPath(int adRow, int adCol, int desRow, int desCol) {
        return Math.max(Math.abs(desRow-adRow),Math.abs(desCol-adCol));
    }


}
