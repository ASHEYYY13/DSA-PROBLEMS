package problemsSolving;

public class isSubset {
  public static void main(String[] args) {
	  int a[]= {10, 5, 2, 23, 19};
	  int b[]= {10, 5, 3};
	  System.out.println(subset(a,b));
  }
 static boolean subset(int[] a, int[] b) {
	
     for(int i=0;i<b.length;i++){
    	 boolean is=false;
         for(int j=0;j<a.length;j++){
             if(b[i]==a[j]){
             is=true;
             break;
             }
         }
         if(is==false){
             return false;
         
         }
         
     }
     return true;
}
  
}
