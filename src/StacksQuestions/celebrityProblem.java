package StacksQuestions;

public class celebrityProblem {
    public static void main(String[] args) {
        int[][] mat={
                {1,1,0},
               {0,1,0},
                {0,1,1}
        };
        System.out.println(findCelebrityOptimal(mat));
    }

    private static int findCelebrity(int[][] mat) {
        int celeb=-1;
        int n=mat.length;
        int[] knowMe=new int[n];
        int[] iKnow=new int[n];
        for (int i = 0; i <n ; i++) {
            for (int j = 0; j <n ; j++) {
                if(i!=j && mat[i][j]==1){
                    knowMe[j]++;
                    iKnow[i]++;
                }
            }
        }
        for (int i = 0; i <n ; i++) {
            if(iKnow[i]==0 && knowMe[i]==n-1){
                celeb=i;
            }
        }

        return celeb;
    }
    private static int findCelebrityOptimal(int[][] mat) {
        int n=mat.length;
        int top=0;
        int down=n-1;
        while (top<down){
            if(mat[top][down]==1){
                top++;
            }
            else if(mat[down][top]==1) {
                down--;
            }
            else {
                top++;
                down--;
            }
        }
        if(top>down){
            return -1;
        }
        for (int i = 0; i <n ; i++) {
            if(mat[top][i]==0 && mat[i][top]==1 || i==top){
                  continue;
            }
            else {
                return -1;
            }
        }
        return top;
    }
}
