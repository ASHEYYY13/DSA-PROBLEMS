package Recursion_pattern_sorting;

public class tringle {
	public static void main(String[] args) {
		triangleOfRecursion(5,5);
	}
	static void triangleOf(int row) {
		for(int i=0;i<row;i++) {
			for(int j=0;j<row-i;j++) {
				System.out.print("A"+" ");
			}
			System.out.println();
		}
	}
	static void triangleOfRecursion(int row,int col) {
		if(row==0) {
			return; 
		}
		if(col<row) {
			triangleOfRecursion(row,col+1);
			System.out.print("*");
		}
		else {
		triangleOfRecursion(row-1,0);  
		System.out.println();
		  
		}
	}
}
