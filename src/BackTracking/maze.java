package BackTracking;

import java.util.ArrayList;

public class maze {
    public static void main(String[] args) {
   ArrayList<String> ans=     pathsOfMaxeReturnDiagonal("",3,3);
        System.out.println(ans);
        System.out.println(countOfMaze(3,3));
    }

    public static int countOfMaze(int row,int col){
        if(row==1 || col==1){
            return 1;
        }
        int down=countOfMaze(row-1,col);
        int right =countOfMaze(row,col-1);
        return down+ right;

    }
    static void pathsOfMaxe(String up,int row,int col){
        if(row==1 && col ==1 ){
            System.out.println(up);
            return;
        }
        if(row>1){
            pathsOfMaxe(up+'D',row-1,col);
        }
        if(col>1){
            pathsOfMaxe(up+'R',row,col-1);
        }
//
//        pathsOfMaxe(up+'D',row-1,col);
//        pathsOfMaxe(up+'R',row,col-1);


    }

    static ArrayList<String> pathsOfMaxeReturn(String up,int row,int col) {
        if (row == 1 && col == 1) {
//            System.out.println(up);
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if (row > 1) {
            ans.addAll(pathsOfMaxeReturn(up + 'D', row - 1, col));
        }
        if (col > 1) {
            ans.addAll(pathsOfMaxeReturn(up + 'R', row, col - 1));
        }

    return ans;
    }


    static ArrayList<String> pathsOfMaxeReturnDiagonal(String up,int row,int col) {
        if (row == 1 && col == 1) {
//            System.out.println(up);
            ArrayList<String> list = new ArrayList<>();
            list.add(up);
            return list;
        }

        ArrayList<String> ans = new ArrayList<>();
        if(row>1 && col>1){
            ans.addAll(pathsOfMaxeReturnDiagonal(up+"DI",row-1,col-1));
        }
        if (row > 1) {
            ans.addAll(pathsOfMaxeReturnDiagonal(up + 'D', row - 1, col));
        }

        if (col > 1) {
            ans.addAll(pathsOfMaxeReturnDiagonal(up + 'R', row, col - 1));
        }

        return ans;
    }

}
