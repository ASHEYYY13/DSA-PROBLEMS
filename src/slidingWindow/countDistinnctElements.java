package slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class countDistinnctElements {
    public static void main(String[] args) {
        int[] arr={1, 2, 1, 3, 4, 2, 3};
        System.out.println(findDistinctInSubArrayOptimal(arr,4));
    }

    private static ArrayList<Integer> findDistinctInSubArray(int[] arr, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        for (int i = 0; i <=arr.length-k ; i++) {
            LinkedHashSet<Integer> linkedHashSet=new LinkedHashSet<>();

            for (int j = i; j <i+k ; j++) {
                linkedHashSet.add(arr[j]);
            }
            ans.add(linkedHashSet.size());
        }
        return ans;
    }
    private static ArrayList<Integer> findDistinctInSubArrayOptimal(int[] arr, int k) {
        ArrayList<Integer> ans=new ArrayList<>();
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i <k ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
        }
        ans.add(map.size());
        for (int i = k; i <arr.length ; i++) {
            map.put(arr[i],map.getOrDefault(arr[i],0)+1);
            map.put(arr[i-k],map.get(arr[i-k])-1);

            if(map.get(arr[i-k])==0){
                map.remove(arr[i-k]);
            }
            ans.add(map.size());
        }
        return ans;
    }
}
