package slidingWindow;

public class smallWindowWithAllCharInString {
    public static void main(String[] args) {
        String s="aabcbcdbca";
        System.out.println(findDistinctWithSmallWindow(s));
    }

    private static int findDistinctWithSmallWindow(String str) {
        boolean[] visited=new boolean[26];
        int n=str.length();
        int distinct=0;
        for (int i = 0; i <n ; i++) {
            if(!visited[str.charAt(i) - 'a']){//this equals visited[str.charAt(i)-'a']==false;
                visited[str.charAt(i)-'a']=true;
                distinct++;
            }
        }

        int[] current=new int[26];
         int count=0;
         int ans=n;
         int start=0;
        for (int i = 0; i <n ; i++) {
            current[str.charAt(i)-'a']++;
            if(current[str.charAt(i)-'a']==1){
                count++;
            }

            while (count==distinct) {
                ans = Math.min(ans, i - start + 1);
                current[str.charAt(start) - 'a']--;
                if (current[str.charAt(start) - 'a'] == 0) {
                    count--;
                }
                start++;
            }
        }
        return ans;
    }
}
