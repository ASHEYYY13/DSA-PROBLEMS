package Problems_Topic_Wise.Recursion_array_Question;

public class finfArraySortedOrNot {
   public static void main(String[] args) {
	   int[] arr= {2,3,5,7,9,1};
//	   System.out.println(arr.length);
	   System.out.println(SortedRecursion(arr));
   }
   
   ///normal way
   static boolean isSorted(int[] arr) {
	  int i=0;
	  while(i<arr.length-1) {
		  if(arr[i]<arr[i+1]) {
			  i++;
		  }
		  else {
			  return false;
		  }
		  
	  }
	  return true;
   }
   static boolean SortedRecursion(int[] arr) {
	   return helper(arr,0);
   }
   static boolean helper(int[] arr,int i) {
	   if(i==arr.length-1) {
		   return true;
	   }
	   return (arr[i]<arr[i+1] && helper(arr,i+1));
   }
}
