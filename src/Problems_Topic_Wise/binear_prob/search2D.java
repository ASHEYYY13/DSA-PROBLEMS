package Problems_Topic_Wise.binear_prob;

import java.util.Arrays;

public class search2D {
  public static void main(String[] args) {
	  int[][] two = {
			  {10,20},
			  {18,28},
			  {27,31},
			  {32,40}
	  };
	  int tar = 31;
	  System.out.println(Arrays.toString(serach(two,tar)));
//	  System.out.println(two.length);
  }
  static int[] serach(int[][] matrix,int target) {
	  int r=0;
	  int c=matrix[0].length-1;
	  while(r<matrix.length && c>=0) {
		  if(matrix[r][c]==target) {
			  return new int[] {r,c};
		  }
		  if(matrix[r][c]<target) {
			  r++;
		  }
		  else {
			  c--;
		  }
	  }
	  return new int[] {-1,-1};
  }
}
