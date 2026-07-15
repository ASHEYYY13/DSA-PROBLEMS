package Problems_Topic_Wise.Recursion_array_Question;

import java.util.ArrayList;

public class findElement {
   public static void main(String[] args) {
	   int[] arr= {1,3,5,3,7,4,3};
	   ArrayList<Integer> list=new ArrayList<>(); 
//	   System.out.println(find2(arr,7,list,0));
	   System.out.println(find3(arr,3,0));
//	   System.out.println(list);
   }
   static boolean find(int[] arr,int target,int i) {
	   if(i>arr.length-1) {
		   return false;
	   }
	   return arr[i]==target?true:find(arr,target,i+1);
   }
   
   static int find1(int[] arr,int target,int i) {
	   if(i>arr.length-1) {
		   return -1;
	   }
	   return arr[i]==target?i:find1(arr,target,i+1);
   }
   
   static ArrayList<Integer> find2(int[] arr,int target,ArrayList<Integer> list,int i) {
	   if(i>arr.length-1) {
		   return list;
	   }
	 if(arr[i]==target) {
		 list.add(i);
	 }
	return  find2(arr,target,list,i+1);
	
   }
   
   
   
   static ArrayList<Integer> find3(int[] arr,int target,int i) {
	   ArrayList<Integer> list = new ArrayList<>();
	   if(i>arr.length-1) {
		   return list;
	   }
	 if(arr[i]==target) {
		 list.add(i);
	 }
ArrayList<Integer> ansOfEachCalls=  find3(arr,target,i+1);
	list.addAll(ansOfEachCalls);
return	list;
   }
}
