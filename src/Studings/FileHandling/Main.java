package Studings.FileHandling;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
//        try(InputStreamReader isr=new InputStreamReader(System.in)){
//            System.out.print("Enter some Letters");
//            int letters= isr.read();
//
//            while (isr.ready()){
//                System.out.println((char) letters);
//                letters= isr.read();
//            }
//            isr.close();
//            System.out.println();
//        }
//        catch (IOException e){
//            System.out.println(e.getMessage());
//        }


        try(FileReader isr=new FileReader("src/Studings/FileHandling/note.txt")){
            int letters= isr.read();

            while (isr.ready()){
                System.out.println((char) letters);
                letters= isr.read();
            }
            isr.close();
            System.out.println();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
