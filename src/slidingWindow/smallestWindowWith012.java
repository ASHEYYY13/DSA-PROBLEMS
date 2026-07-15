package slidingWindow;

import java.util.HashSet;
import java.util.Set;

public class smallestWindowWith012 {
    public static void main(String[] args) {
        String s="10212";
        System.out.println(smallWindow(s));
    }

    private static int smallWindow(String str) {
        int zero=0;
        int one=0;
        int two=0;
        int ans=-1;
        int j=0;
        // i meaning right j meaning left
        for (int i = 0; i < str.length() ; i++) {
           if(str.charAt(i)=='0'){
               zero++;
           } else if (str.charAt(i)=='1') {
               one++;
           }
           else {
               two++;
           }

           while (one>=1 && zero>=1 && two>=1){
               if(ans==-1){
                   ans=i-j+1;
               }
               else {
                   ans=Math.min(ans,i-j+1);
               }

               if(str.charAt(j)=='0'){
                   zero--;
               } else if (str.charAt(j)=='1') {
                   one--;
               }
               else {
                   two--;
               }

               j++;
           }
        }

        return ans;
    }


//    private static int smallWindowOPtimized(String str) {
//        int zero=0;
//        int one=0;
//        int two=0;
//        int length=-1;
//
//        for (int i = 0; i < str.length() ; i++) {
//
//        }
//    }

}
