package Trees.AVLTrees;

public class AvlTrees {
    public AvlTrees() {
    }

    public class Node{
        private int value;
        private int height;
        private Node right;
        private Node left;

        public Node(int value) {
            this.value = value;
        }
        public int getValue(){
            return value;
        }

    }



    public int height() {
        return height(root);
    }

    private Node root;

    public int height(Node node){
        if(node==null){
            return 0;
        }
        return node.height;
    }

    public boolean isEmpty(){
        return root==null;
    }

    public void display(){
        display(root,"Root node: ");
    }

    private void display(Node node, String details) {
        if(node==null){
            return;
        }
        System.out.println(details+node.getValue());
        display(node.left,"Left child of "+node.getValue()+":");
        display(node.right,"right` child of "+node.getValue()+":");
    }
    public void insert(int value){
        root=  insert(value,root);
    }
    private Node insert(int value, Node node){
        if(node==null){
            node=new Node(value);
            return node;
        }
        if(value>node.value){
            node.right=insert(value,node.right);
        }
        if (value<node.value){
            node.left=insert(value,node.left);
        }
        node.height=Math.max(height(node.left),height(node.right))+1;
        return rotate(node);
    }

    private Node rotate(Node node) {
        if(height(node.left)-height(node.right)>1){
            //left heavy meaning left side has more nodes
            if(height(node.left.left)-height(node.left.right)>0){
                //left-left case
                return rightRotate(node);
            }
            if(height(node.left.left)-height(node.left.right)<0){
                //right left case
                node.left=leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left)-height(node.right)<-1){
            //right heavy
            if(height(node.right.left)-height(node.right.right)<0){
                //right-right case
                return leftRotate(node);
            }
            if(height(node.right.left)-height(node.right.right)>0){
                //left right case
                node.right=rightRotate(node.left);
                return leftRotate(node);
            }
        }
        return node;
    }

    private Node leftRotate(Node c) {
        Node p=c.right;
        Node t=p.left;

       p.left=c;
       c.right=t;

        p.height=Math.max(height(p.left),height(p.right));
        c.height=Math.max(height(c.left),height(c.right));

        return p;
    }

    private Node rightRotate(Node p) {
        Node c=p.left;
        Node t=c.right;

        c.right=p;
        p.left=t;

        p.height=Math.max(height(p.left),height(p.right));
        c.height=Math.max(height(c.left),height(c.right));

        return c;
    }

    public  boolean balanced(){
        return    balanced(root);
    }
    private boolean balanced(Node node){
        if(node==null){
            return true;
        }
        return Math.abs(height(node.right)-height(node.left))<=1 &&
                balanced(node.left) && balanced(node.right);
    }

    public void populate(int[] nums){
        for (int i = 0; i < nums.length ; i++) {
            insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums){
        populatedSorted(nums,0,nums.length);
    }
    private void populatedSorted(int[] nums,int start,int end){
        if(start>=end){
            return;
        }
        int mid=(start+end)/2;

        insert(nums[mid]);
        populatedSorted(nums,start,mid);
        populatedSorted(nums,mid+1,end);
    }

    public void preOrder(){
        preOrder(root);
    }
    private void preOrder(Node node){
        if(node==null){
            return;
        }
        System.out.print(node.value+ "-->");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void inOrder(){
        inOrder(root);
    }
    private void inOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        System.out.print(node.value+ "-->");
        preOrder(node.right);
    }
    public void postOrder(){
        postOrder(root);
    }
    private void postOrder(Node node){
        if(node==null){
            return;
        }
        preOrder(node.left);
        preOrder(node.right);
        System.out.print(node.value+ "-->");
    }
}
