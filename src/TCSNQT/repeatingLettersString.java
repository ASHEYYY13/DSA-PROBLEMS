package TCSNQT;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class repeatingLettersString
{
    public static void main(String[] args) {
        String input;

        Scanner scan=new Scanner(System.in);
        input=scan.nextLine();

        if(input.isEmpty()){
            System.out.println("invalid input");
            return;
        }
        HashMap<Character,Integer> frequency=new HashMap<>();
        HashMap<Character,Integer> firstIndex=new HashMap<>();

        //saving frequency of each character in the String
        //saving the each character in the string in their index
        for (int i = 0; i<input.length() ; i++) {
            char c=input.charAt(i);
          frequency.put(c,frequency.getOrDefault(c,0)+1);
          if(!firstIndex.containsKey(c)){
              firstIndex.put(c,i);
          }
        }
        //finding the non first nonRepeating character in the string
        //if no char has nonRepeating char isNonRepeating will be false
        // then we return None for that
        char NonRepeating='\0';
        boolean isNonRepeating=false;
        for (int i = 0; i <input.length() ; i++) {
            char c=input.charAt(i);
            if(frequency.get(c)==1){
                isNonRepeating=true;
                NonRepeating=c;
                break;
            }
        }
       //find the mostFrequent letters
        int maxFreq=0;
        for (Map.Entry<Character,Integer> entry:frequency.entrySet()){
            maxFreq=Math.max(maxFreq,entry.getValue());
        }

        char mostRepeated='\0';
        int early=input.length();
        for (Map.Entry<Character,Integer> entry:frequency.entrySet()){
            char c= entry.getKey();
            int freq=entry.getValue();
            if(freq==maxFreq){
                int index=firstIndex.get(c);
            if(index<early){
                early=index;
                mostRepeated=c;
            }
            }
        }
        char firstRepeating='\0';
        boolean hasRepeating=false;

        for (int i = 0; i <input.length() ; i++) {
            char c=input.charAt(i);
            if(frequency.get(c)>1){
                firstRepeating=c;
                hasRepeating=true;
                break;
            }
        }

        if(!isNonRepeating){
            System.out.println("None");
            if (hasRepeating){
                System.out.println(firstRepeating);
            }
        }
        else {
            System.out.println(NonRepeating);
            System.out.println(mostRepeated);
        }
    }
}
