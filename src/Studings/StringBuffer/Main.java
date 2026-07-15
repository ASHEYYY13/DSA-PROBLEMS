package Studings.StringBuffer;

public class Main {
    public static void main(String[] args) {
        StringBuffer sb=new StringBuffer();//constructor 1 initial capacity 16
        StringBuffer sb2= new StringBuffer("ASWIN SALOMON ");//constructor 2
        StringBuffer sb3= new StringBuffer(19);//constructor 3 we can initialize capacity of string

        sb.append("Asheyyyy");
        String str=sb.toString();
//        System.out.println(str);
//        System.out.println(sb);
        System.out.println(sb.capacity());
        System.out.println(sb2.capacity());
        System.out.println(sb3.capacity());
        System.out.println(RandomString.generate(20));
        String name="hjh  hf fgbre  rgbf grgg     g";
        System.out.println(name.replaceAll("\\s", ""));
    }
}
