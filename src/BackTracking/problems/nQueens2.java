package BackTracking.problems;

import java.util.ArrayList;
import java.util.List;

public class nQueens2 {
    public static void main(String[] args) {
        int n=4;
        boolean[][] board=new boolean[n][n];
        List<List<String>> mainList=queens2(board,0);
        System.out.println(mainList);
    }
    static List<List<String>> queens2(boolean[][] board, int row){
        if(row== board.length){
            List<List<String>> returList=new ArrayList<>();
            returList.add(display(board));
            return returList;
        }
//        int count=0;
        List<List<String>> List=new ArrayList<>();
        for (int col = 0; col <board.length ; col++) {
            if(isSafe(board,row,col)){
                board[row][col]=true;
                List.addAll(queens2(board,row+1));
                board[row][col]=false;
            }
        }
        return List;
    }

    private static boolean isSafe(boolean[][] board, int row, int col) {
        //vertical
        for (int i = 0; i <row ; i++) {
            if(board[i][col]){
                return false;
            }
        }
        //diagonal left
        int maxLeft=Math.min(row,col);
        for (int i = 1; i <=maxLeft; i++) {
            if(board[row-i][col-i]){
                return false;
            }
        }
        //diagonal right
        int maxRight=Math.min(row,board.length-col-1);
        for (int i = 1; i <=maxRight; i++) {
            if(board[row-i][col+i]){
                return false;
            }
        }
        return true;
    }

    private static List<String> display(boolean[][] board) {
        List<String> list=new ArrayList<>();
        for (boolean[] booleans : board) {
            StringBuilder up= new StringBuilder();
            for (int j = 0; j < board[0].length; j++) {
                if (booleans[j]) {
                    up.append("Q");
                }
                     else {
                    up.append(".");
                }
            }
            list.add(up.toString());
        }
        return list;
    }
}
