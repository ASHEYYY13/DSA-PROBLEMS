package BackTracking;

import java.util.Arrays;

public class mazeWithObstacles {
    public static void main(String[] args) {
        boolean[][] maze={
                {true,true,true},
                {true,true,true},
                {true,true,true}
        };
        int[][] step=new int[maze.length][maze[0].length];
       AllpathsWithSteps("",step,1,maze,0,0);
    }
    static void pathWithContraints(String up,boolean[][] maze,int row,int col){
        if(row==maze.length-1 && col==maze[0].length-1 ){
            System.out.println(up);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        if(row<maze.length-1){
            pathWithContraints(up+'D',maze,row+1,col);
        }
        if(col<maze[0].length-1){
            pathWithContraints(up+'R',maze,row,col+1);
        }
    }

    static void Allpaths(String up,boolean[][] maze,int row,int col){
        if(row==maze.length-1 && col==maze[0].length-1 ){
            System.out.println(up);
            return;
        }
        if(!maze[row][col]){
            return;
        }
        //before doing recursion call make the before block as false
        maze[row][col]=false;
        if(row<maze.length-1){
            Allpaths(up+'D',maze,row+1,col);

        }
        if(col<maze[0].length-1){
            Allpaths(up+'R',maze,row,col+1);

        }
        if(col>0){
            Allpaths(up+"L",maze,row,col-1);
        }
        if(row>0){
            Allpaths(up+"U",maze,row-1,col);

        }
       maze[row][col]=true;
        //this is where the function will get over
        //so  remove the changes we have done before
        // the function end
        //make it back to its original way of true
    }
    static void AllpathsWithSteps(String up,int[][] step,int level,boolean[][] maze,int row,int col){
        if(row==maze.length-1 && col==maze[0].length-1 ){
      step[row][col]=level;
           for(int[] arr:step){
               System.out.println(Arrays.toString(arr));
           }
            System.out.println(up);
            System.out.println();
        }
        if(!maze[row][col]){
            return;
        }
        //before doing recursion call make the before block as false
        maze[row][col]=false;
        step[row][col]=level;
        if(row<maze.length-1){
            AllpathsWithSteps(up+'D',step,level+1,maze,row+1,col);

        }
        if(col<maze[0].length-1){
            AllpathsWithSteps(up+'R',step,level+1,maze,row,col+1);

        }
        if(col>0){
            AllpathsWithSteps(up+"L",step,level+1,maze,row,col-1);
        }
        if(row>0){
            AllpathsWithSteps(up+"U",step,level+1,maze,row-1,col);

        }
        maze[row][col]=true;
        //this is where the function will get over
        //so  remove the changes we have done before
        // the function end
        //make it back to its original way of true
        step[row][col]=0;
    }
}
