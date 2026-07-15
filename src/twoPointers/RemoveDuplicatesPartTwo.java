package twoPointers;

public class RemoveDuplicatesPartTwo {
    public static int RemoveDuplicatesPartTwo(int[] arr){
        int left=0;
        int right=0;

        while (right<arr.length){
            int count=1;

            while (right<arr.length-1 && arr[right]==arr[right+1]){
                count++;
                right++;
            }

            for (int i = 0; i <Math.min(2,count) ; i++) {
                arr[left]=arr[right];
                left++;
            }


            right++;
        }
        return left;
    }
}
