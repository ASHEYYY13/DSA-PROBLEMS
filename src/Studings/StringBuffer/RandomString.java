package Studings.Strings.StringBuffer;

import java.util.Random;

public class RandomString {
    static  String generate(int size){

        StringBuffer stringBuffer=new StringBuffer(size);
        Random random=new Random();
        for (int i = 0; i <size ; i++) {
            int  charNumber=97+ (int)(random.nextFloat()*26);

            stringBuffer.append((char)charNumber);
        }

        return stringBuffer.toString();
    }
}
