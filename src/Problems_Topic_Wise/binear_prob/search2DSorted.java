package binear_prob;

import java.util.Arrays;

public class search2DSorted {
  public static void main(String[] args) {
	  int[][] twoDArray = {
			  {1,2,3,4},
			  {5,6,7,8},
			  {9,10,11,12},
			  {13,14,15,16}
	  };
	  
	  System.out.println(Arrays.toString(sortedMatrix(twoDArray,7)));
	  
  }
  
  static int[] binearySearch(int[][] matrix, int row, int Cstart, int Cend, int target ) {
	   while(Cstart<=Cend) {
		   int mid = Cstart + (Cend - Cstart)/2;
		   if(matrix[row][mid]==target) {  //this will search in the provided row and in given start and column
			   return new int[] {row,mid};
		   }
        if (matrix[row][mid]<target) {
			   Cstart = mid+1;
		   }
		   else {
			   Cend = mid-1;
		   }
	   }
	   return new int[] {-1,-1};
  }
  static int[] sortedMatrix(int[][] matrix,int target) {
	  int row = matrix.length;
	  int col =matrix[0].length;
	
	  if(row==1) {
		  return binearySearch(matrix,0,0,col-1,target);
	  }
     int rStart =0;
     int rEnd =row-1;
     int cMid = col/2;
   //this will run untill two rows;
     while(rStart<(rEnd-1)) {
    	 int mid = rStart + (rEnd - rStart)/2;
    	 if(matrix[mid][cMid]==target) {
    		 return new int[] {mid,cMid};
    	 }
    	 if(matrix[mid][cMid]<target) {
    		rStart= mid +1;
    		 
    	 }
    	 else {
    		 rEnd=mid;
    	 }
     }
     //now we have two rows
//     check if the middle colo=umn has the target
     
     if(matrix[rStart][cMid]==target) {
    	 return new int[] {rStart,cMid};
     }
     if(matrix[rStart+1][cMid]==target) {
    	 return new int[]{rStart+1,cMid};
     }
     //search in 1st half thats before matrix[rStart][cMid]
     if(matrix[rStart][cMid-1]>=target) {
    	 return binearySearch(matrix,rStart,0,cMid-1,target);
     }
     //search in second half 
     if(matrix[rStart][cMid+1]<=target && matrix[rStart][col-1]>=target) {
    	 return binearySearch(matrix,rStart,cMid+1,col-1,target);
     }
     if(matrix[rStart+1][0]<=target && matrix[rStart+1][cMid-1]>=target ) {
    	 return binearySearch(matrix,rStart+1,0,cMid-1,target);
     }
     else {
    	 return binearySearch(matrix,rStart+1,cMid+1,col-1,target);
     }
  }
}
