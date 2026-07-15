package Problems_Topic_Wise.twoPointers;

public class ValidPalindrome {
    public static boolean validaPalindrome(String string){
        string= string.replaceAll("[^a-zA-Z0-9]","").toLowerCase();

        int i=0;
        int j=string.length()-1;
        int length=string.length()/2;
        for (int k = 0; k <length ; k++) {
          if(string.charAt(i)==string.charAt(j)){
              i++;
              j--;
          }
          else {
              return false;
          }
        }

        return true;
    }

//    public static boolean validaPalindrome2(String string){
//
//    }
}
