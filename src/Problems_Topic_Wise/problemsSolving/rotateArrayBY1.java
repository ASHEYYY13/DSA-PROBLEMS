package Problems_Topic_Wise.problemsSolving;

import java.util.ArrayList;
import java.util.Arrays;

public class rotateArrayBY1 {
   public static void main(String[] args) {
	   int[] arr= {1,2,3};
	   ArrayList<Integer> list = new ArrayList<>();
	   for(int num:arr) {
		   list.add(num);
	   }
	   System.out.println(rotatebyOpti(list,1));
   }

static int[] rotate(int[] arr) {
   int i=0;
   int j=arr.length-1;
   while(i!=j) {
	   int temp=arr[i];
	   arr[i]=arr[j];
	   arr[j]=temp;
	   i++;
   }
   return arr;
}
static ArrayList<Integer> rotateby(ArrayList<Integer> list,int k){
	int n=list.size();
	int d=k%n;
	int temp[]= new int[d];
	for(int i=0;i<d;i++) {
		temp[i]=list.get(i);
	}
	for(int i=d;i<n;i++) {
		list.set(i-d,list.get(i));
	}
	for(int i=n-d;i<n;i++) {
		list.set(i, temp[i-(n-d)]);
	}
	return list;
}
static ArrayList<Integer> rotatebyOpti(ArrayList<Integer> list,int k){
	int n=list.size();
	int d=k%n;
	reverse(list,0,d-1);
	reverse(list,d,n-1);
	reverse(list,0,n-1);
	return list;
}

static  void reverse(ArrayList<Integer> list,int start,int end){
	while(start<=end) {
		int temp=list.get(start);
		list.set(start, list.get(end));
		list.set(end, temp);
		start++;
		end--;
	}
}
}
