package Problems_Topic_Wise.Reccursion_programs;

public class binearySearchRecursion {

	public static void main(String[] args) {
		int[] array= {1,2,3,12,13,32,53,54,56,66};
		int target=53;
        System.out.println(search(target,array,0,array.length-1));
	}
	static int search(int tar,int[] arr,int s,int e) {
	    
		if(s>e) {
			return -1;
		}
		int m = s -(s-e)/2;
		if(arr[m]==tar) {
			return m;
		}
		if(arr[m]>tar) {
		 return	search(tar,arr,s,m-1);
		}
	   
		return search(tar,arr,m+1,e);
		
	}

}
