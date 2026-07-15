package twoPointers;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

//        System.out.println(ValidPalindrome.validaPalindrome("A man, a plan, a canal: Panama"));
//        System.out.println(ValidPalindrome.validaPalindrome("race a car"));
//        System.out.println(ValidPalindrome.validaPalindrome(" "));


        char[] s = {'h', 'e', 'l', 'l', 'o'};

        int[] numbers = {-1,0};
        int target = -1;
        ReverseString.ReverseString(s);
//        System.out.println(s);
//        System.out.println(Arrays.toString(TwoSum.twoSum(numbers, target)));
//
//        int[] arr={-7,-3,2,3,11};
//        int[] arr2={-7,-3,2,3,11};
//        System.out.println(Arrays.toString(SquaresOfSortedArray.SquaresOfSortedArrayBrute(arr)));
//        System.out.println(Arrays.toString(SquaresOfSortedArray.SquaresOfSortedArrayOptimal(arr2)));


//        int[] nums={0,1,0,3,12};
//        int[] nums2={0};
//        MoveZeros.moveZeroesOptimal(nums);
//        System.out.println(Arrays.toString(nums));
//
//        int[] nums={-1,0,1,2,-1,-4};
//        int[] nums2={0,1,1};
//        List<List<Integer>> ans = ThreeSum.threeSumOptimal(nums);
//        System.out.println(ans);

//        int[] arr={-1,2,1,-4};
//        System.out.println(ThreeSumClosest.threeSumClosest(arr,1));

//        int[] arr = {2, 1, 8, 6, 4, 6, 5, 5};
//        System.out.println(ContainerwithMostWater.ContainerwithMostWaterOpyimal(arr));

//        int[] arr={2,0,2,1,1,0};
//        SortColors.sortColors(arr);
//        System.out.println(Arrays.toString(arr));

//        int[] arr={1,1,1,2,2,2,3,3};
//        System.out.println(RemoveDuplicatesPartTwo.RemoveDuplicatesPartTwo(arr));

        int[] arr={1000000000,1000000000,1000000000,1000000000};
        List<List<Integer>> ans = FourSum.fourSum(arr,-294967296);
        System.out.println(ans);
    }
}
