package QueueQuestions;

import java.util.LinkedList;
import java.util.Queue;

public class StreamFirst {
    public static void main(String[] args) {
        String s="aabc";
        System.out.println(nonRepeating(s));
    }

    private static String nonRepeating(String s) {
        StringBuilder ans=new StringBuilder();
        int[] count=new int[26];
        Queue<Character> queue=new LinkedList<>();
        for (int i = 0; i <s.length() ; i++) {
            if(count[s.charAt(i)-'a']==0){
                queue.add(s.charAt(i));
            }
            count[s.charAt(i)-'a']++;
            while (!queue.isEmpty() && count[queue.peek()-'a']>1){
               queue.poll();
            }

            if(!queue.isEmpty()){
                ans.append(queue.peek());
            }
            else {
                ans.append('#');
            }

        }
      return ans.toString();
    }
}
