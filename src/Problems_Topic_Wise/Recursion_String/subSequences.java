package Problems_Topic_Wise.Recursion_String;

import java.util.ArrayList;

public class subSequences {
   public static void main(String[] args) {
//	   subStrings("","APC");
	   System.out.println( subStrings1("","APC"));
   }
   static void subStrings(String p, String up) {
	   if(up.isEmpty()) {
		   System.out.println(p);
		   return;
	   }
	   char ch=up.charAt(0);
	   subStrings(ch+p,up.substring(1));
	   subStrings(p,up.substring(1));
	 
   }
   static ArrayList<String> subStrings1(String p, String up) {
	   if(up.isEmpty()) {
		   ArrayList<String> list=new ArrayList<>();
		   if(!p.isEmpty()) {
		   list.add(p);
		   }
		   return list;
	   }
	   char ch=up.charAt(0);
	   ArrayList<String> left=   subStrings1(ch+p,up.substring(1));
	   ArrayList<String> right= subStrings1(p,up.substring(1));
	   ArrayList<String> ASCII= subStrings1(p+(ch+0),up.substring(1));
	 left.addAll(right);
	 left.addAll(ASCII);
	 return left;
   }
}
