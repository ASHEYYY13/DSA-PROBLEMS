package Problems_Topic_Wise.Recursion_String;

import java.util.ArrayList;
import java.util.Arrays;

public class subSets {
   public static void main(String[]args) {
	   int[] arr= {1,2,3};
	   ArrayList<ArrayList<Integer>> ans=subSetsInArrays(arr);
//	   for(ArrayList<Integer> list:ans) {
//		   System.out.println(list);
//	   }
	   System.out.println(ans);
   }
   static ArrayList<ArrayList<Integer>> subSetsInArrays(int[] arr){
	   ArrayList<ArrayList<Integer>> outer =new ArrayList<>();
	   outer.add(new ArrayList<>());
	   int count=0;
	   for(int num:arr) {
		   int n=outer.size();
		   for(int i=0;i<n;i++) {
			   ArrayList<Integer> list=new ArrayList<>(outer.get(i));
			   list.add(num);
			   outer.add(list);
			   count++;   
		   }
	   }
	   System.out.println(count);
	   return outer;
	
   }
   static ArrayList<ArrayList<Integer>> subSetsInArraysWithoutDuplicates(int[] arr){
	   Arrays.sort(arr);
	   ArrayList<ArrayList<Integer>> outer =new ArrayList<>();
	   outer.add(new ArrayList<>());
	   int start=0;
	   int end=0;
	   for(int num=0;num<arr.length;num++) {
		   start=0;
		   if(num>0 &&arr[num]==arr[num-1]) {
			   start=end+1;
		   }
		   end=outer.size()-1;
		   int n=outer.size();
		   for(int i=start;i<n;i++) {
			   ArrayList<Integer> list=new ArrayList<>(outer.get(i));
			   list.add(arr[num]);
			   outer.add(list);
			   
		   }
	   }
	   return outer;
   }
}
