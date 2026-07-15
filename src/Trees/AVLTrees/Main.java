package Trees.AVLTrees;

public class Main {
    public static void main(String[] args) {
        AvlTrees avlTrees=new AvlTrees();

        for (int i = 0; i <1000 ; i++) {
            avlTrees.insert(i);
        }
        System.out.println(avlTrees.height());
    }



}
