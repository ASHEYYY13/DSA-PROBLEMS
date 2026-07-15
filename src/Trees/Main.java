package Trees;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
//        BinaryTrees trees=new BinaryTrees();
//        trees.population(scan);
//        trees.prettyDisplay();

        BinarySearchTrees tree= new BinarySearchTrees();
        int[] nums={1,2,3,5,6,7,8,9};
        tree.populatedSorted(nums);
        tree.inOrder();
        System.out.println(tree.balanced());

    }
}
