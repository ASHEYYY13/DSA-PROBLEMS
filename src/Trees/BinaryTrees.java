package Trees;

import java.net.Socket;
import java.util.Scanner;

public class BinaryTrees {
    public BinaryTrees() {
    }

    private static class Node{
        int value;
        Node right;
        Node left;

        public Node(int value) {
            this.value = value;
        }
    }

    private static Node root;

    public void population(Scanner scan){
        System.out.println("Enter the value of  RootNode:");
        int value=scan.nextInt();
    root=new Node(value);
    populate(scan,root);
    }

    private void populate(Scanner scan, Node node) {
        System.out.println("Do you want to Insert LeftNode"+node.value);
        boolean left=scan.nextBoolean();
        if(left){
            System.out.println("Enter the value of thr left of " + node.value);
            int value=scan.nextInt();
            node.left=new Node(value);
            populate(scan,node.left);
        }
        System.out.println("DO you want to inside rightNode for"+node.value);
        boolean right=scan.nextBoolean();
        if(right){
            System.out.println("Enter the value of thr right of " + node.value);
            int value=scan.nextInt();
            node.right=new Node(value);
            populate(scan,node.right);
        }
    }

    public void prettyDisplay(){
        prettyDisplay(root,0);
    }

    private void prettyDisplay(Node node, int level) {
        if(node==null){
            return;
        }

        prettyDisplay(node.right,level+1);
        if(level!=0){
            for (int i = 0; i <level-1 ; i++) {
                System.out.print("|\t\t");
            }
            System.out.println("|------->"+node.value);
        }
        else {
            System.out.println(node.value);
        }
        prettyDisplay(node.left,level+1);
    }
}
