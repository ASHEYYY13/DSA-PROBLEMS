package Problems_Topic_Wise.twoPointers;

public class ReverseString {
    public static void ReverseString(char[] c){
        int i=0;
        int j=c.length-1;
      while (i<j){
          char temp=c[i];
          c[i]=c[j];
          c[j]=temp;
          i++;
          j--;
      }
    }
}
