package BasicProblems;

public class CountDIgitsThatDIvide {
    public  static int evenlyDivides(int n) {

        int value=n;
        int count=0;
     while(value>0){
         int digit=value%10;
         value=value/10;
         if(n%digit==0){
             count++;
         }
     }

     return count;

    }
}
