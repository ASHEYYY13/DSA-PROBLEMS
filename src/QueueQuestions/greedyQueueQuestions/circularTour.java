package QueueQuestions.greedyQueueQuestions;

public class circularTour {
    public static void main(String[] args) {
        int[] gas={4, 5, 7, 4};
        int[] cost={6, 6, 3, 5};
        System.out.println(gasStation(gas,cost));
    }

    private static int gasStation(int[] gas, int[] cost) {
         int startIndex=0;
         int n=gas.length;
         int currentGas=0;
         int totalGas=0;
        for (int i = 0; i <n ; i++) {
            totalGas+=gas[i]-cost[i];
            currentGas+=gas[i]-cost[i];

            if(currentGas<0){
                currentGas=0;
                startIndex=i+1;
            }
        }
        if(totalGas<0){
            return -1;
        }
        return startIndex;
    }
}
