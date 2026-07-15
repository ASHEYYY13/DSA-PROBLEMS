package Recursion_String;

public class skipCharacter {
     public static void main(String[] args) {
//    	String str= skip1("bsaahydiedbd");
    	 System.out.println(skip1("apaple"));
     }
     static String skip(String p,String up) {
    	 if(up.isEmpty()) {
    		 System.out.println(p);
    		 return p;
    	 }
    	 if(up.charAt(0)=='a') {
    		return skip(p,up.substring(1));
    	 }
    	 else {
    		return skip(p+up.charAt(0),up.substring(1));
    	 }
     }
     static String skip1(String up) {
    	 if(up.isEmpty()) {
    	   return "";
    	 }
    	 if(up.charAt(0)=='a') {
    		return skip1(up.substring(1));
    	 }
    	 else {
    		return up.charAt(0)+skip1(up.substring(1));
    	 }
     }
}
