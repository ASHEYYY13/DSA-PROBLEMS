package binear_prob;

public class ceiling_in_char {
   public static void main(String[] args) {
	   char[] ch ={'c','f','j'};
	   char target = 'f';
	   System.out.println(celingchar(ch,target));
   }
   
   static char celingchar(char[] arr,char target) {
	   int start = 0;
	   int end =arr.length-1;
	   while(start <= end) {
		   int mid = start + (end-start)/2;
		   
		   if(target<arr[mid]) {
			   end = mid -1;
		   }
		   else {
			     start = mid+1;
		   }
	      if(start==arr.length) {
	    	  return arr[0];
	      }
	   }
	   return arr[start];
   }
}
