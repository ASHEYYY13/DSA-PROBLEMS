package BinearySearchProblems;

import java.util.ArrayList;

public class kthRotation {
    public static void main(String[] args) {
       int[] arr={39 ,6 ,11 ,14 ,18 ,36, 37, 38};
        System.out.println(rotationUsingArrayList(arr));
    }

    private static int rotation(int[] arr) {
        int start=0;
        int end=arr.length-1;
//        int ans=Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[start]<=arr[end]){
                return start;
            }
            if(arr[mid]<=arr[end]){
               end=mid-1;
            }

            else {
                start=mid+1;
            }
        }
        return start;
    }
    private static int rotationUsingArrayList(int[] arr) {
        ArrayList<Integer> list=new ArrayList<>();
        for (int i = 0; i <arr.length ; i++) {
           list.add(arr[i]);
        }
        int start=0;
        int end=list.size()-1;
//        int ans=Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(list.get(start)<=list.get(end)){
                return start;
            }
            if(list.get(mid)<=list.get(end)){
                if(list.get(mid)<list.get(mid-1)){
                    return mid;
                }
                end=mid-1;
            }

            else {
                if(list.get(mid)>list.get(mid+1)){
                    return mid+1;
                }
                start=mid+1;
            }
        }
        return start;
    }



}
