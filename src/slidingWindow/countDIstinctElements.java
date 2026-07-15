package slidingWindow;

import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class countDIstinctElements {
    public static void main(String[] args) {
        String s="aabab";
        System.out.println(countDIstinctOptimal(s,3));
    }

    private static int countDIstinct(String s, int k) {
        int n=s.length();
        int count=0;
        for (int i=0;i<=n-k;i++){
            Set<Character> set=new LinkedHashSet<>();
            for (int j=i;j<i+k;j++){
               set.add(s.charAt(j));
            }
            if(set.size()==k-1){
                count++;
            }
        }
        return count;
    }

    private static int countDIstinctOptimal(String s, int k) {
        int n=s.length();
        int count=0;
        int i=0;
        int j=0;
        Map<Character,Integer> map=new HashMap<>();
        while (j<n){
           if(j-i+1<=k){
               map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);
               j++;
           }
           else {
               if(map.size()==k-1){
                   count++;
               }
               map.put(s.charAt(i),map.get(s.charAt(i))-1);
               if(map.get(s.charAt(i))==0){
                   map.remove(s.charAt(i));
               }
               i++;
           }

        }
        if(map.size()==k-1){
            count++;
        }
        return count;
    }
}
