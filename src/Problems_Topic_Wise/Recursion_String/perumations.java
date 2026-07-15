package Problems_Topic_Wise.Recursion_String;

public class perumations {
    public static void main(String[] args) {
    	String str="123";
    	permu("",str);
    }
    static void permu(String p,String up) {
    	if(up.length()==0) {
    		System.out.println(p);
    		return;
    	}
    	char ch=up.charAt(0);
    	for(int i=0;i<=p.length();i++) {
    		String f=p.substring(0,i);
    		String s=p.substring(i, p.length());
    		permu(f+ch+s,up.substring(1));
    	}
    }

}
