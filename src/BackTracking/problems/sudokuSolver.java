package BackTracking.problems;

public class sudokuSolver {
    public static void main(String[] args) {
//     int[][] board={
//             {5,3,0,0,7,0,0,0,0},
//             {6,0,0,1,9,5,0,0,0},
//             {0,9,8,0,0,0,0,6,0},
//             {8,0,0,0,6,0,0,0,3},
//             {4,0,0,8,0,3,0,0,1},
//             {7,0,0,0,2,0,0,0,6},
//             {0,6,0,0,0,0,2,8,0},
//             {0,0,0,4,1,9,0,0,5},
//             {0,0,0,0,8,0,0,7,9}
//     };
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
     if(solve(board)){
         display(board);
     }
     else {
         System.out.println("can't do it fuck off");
     }
    }
static boolean solve(char[][] board){
        int n= board.length;
        int row=-1;
        int col=-1;
        boolean  emptyLeft=true;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            if (board[i][j] == '.') {
                row = i;
                col = j;
                emptyLeft = false;
                break;
            }
        }
        if (!emptyLeft) {
              break;
        }
    }
    if(emptyLeft){
            return true;
    }
    for (int number = 1; number <=9 ; number++) {
        char numchar=(char) ('0'+number);
        if(isSafe(board,row,col,numchar)){
            board[row][col]=numchar;
            if(solve(board)){
                return true;
            }
           else {
               board[row][col]='.';
            }
        }
    }
    return false;
}
static void display(char[][] board){
    for (char[] row:board) {
        for (char col:row) {
            System.out.print(col +" ");
        }
        System.out.println();
    }
}

    static boolean isSafe(char[][] board,int row,int col,char num){
        //check the rows
        for (int i = 0; i <board.length ; i++) {
            if(board[row][i]==num){
                return false;
            }
        }
        //check  the columns
        for (char[] ints : board) {
            if (ints[col] == num) {
                return false;
            }
        }
        int sqrt=(int)(Math.sqrt(board.length));
        int start=row-row%sqrt;
        int end=col-col%sqrt;
        for (int i = start; i <start+sqrt ; i++) {
            for (int j = end; j <end+sqrt ; j++) {
                if(board[i][j]==num){
                    return false;
                }
            }
        }
        return true;
    }
}
