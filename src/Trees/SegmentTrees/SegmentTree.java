package Trees.SegmentTrees;

public class SegmentTree {
    private static class Node{
        int data;
        int startingInterval;
        int endingInterval;
        Node right;
        Node left;


        public  Node(int startingInterval, int endingInterval){
            this.startingInterval=startingInterval;
            this.endingInterval=endingInterval;
        }
    }
    Node root;



    public SegmentTree(int[] arr){
        this.root=constructSegmentTree(arr,0,arr.length-1);
    }

    private Node constructSegmentTree(int[] arr, int startIndex, int endIndex)
    {
        if(startIndex==endIndex){
            Node leaf=new Node(startIndex,endIndex);
            leaf.data=arr[startIndex];
            return leaf;
        }
        Node node=new Node(startIndex,endIndex);
        int mid=(startIndex+endIndex)/2;
        node.left=constructSegmentTree(arr,startIndex, mid);
        node.right=constructSegmentTree(arr,mid+1,endIndex);
        node.data=node.left.data+node.right.data;

        return node;
    }

    public void display(){
        this.display(this.root);
    }

    private void display(Node node){

        String str="";
        if(node.left!=null){
            str=str+"Interval=["+node.left.startingInterval + "-" + node.left.endingInterval +"] and data:" + node.left.data+"+=>";
        }
        else {
            str=str+"No Left Child";
        }

        //for current Node
        str=str+"Interval=["+ node.startingInterval + "-" + node.endingInterval +"] and data:" + node.data+"+<=" ;


        if(node.right!=null){
            str=str+"Interval=["+node.right.startingInterval + "-" + node.right.endingInterval +"] and data:" + node.right.data;
        }
        else {
            str=str+"No Right Child";
        }

        System.out.println(str + "\n");

        if(node.left!=null){
            display(node.left);
        }

        if(node.right!=null){
            display(node.right);
        }


    }



    public int query(int queryStartIndex,int queryEndIndex){
      return   this.query(this.root,queryStartIndex,queryEndIndex);
    }

    private int query(Node node,int startIdx,int endIdx){
        if(node.startingInterval>=startIdx && node.endingInterval<=endIdx){
            return node.data;
        }
        else if(node.startingInterval>endIdx || node.endingInterval<startIdx){
            return 0;
        }
        else {
            return this.query(node.left,startIdx,endIdx)+this.query(node.right,startIdx,endIdx);
        }
    }


    public void update(int index,int value){
        this.root.data=   this.update(this.root,index,value);
    }

    private int update(Node node,int index,int value){
        if(node.startingInterval<=index &&  index<=node.endingInterval){
            if(node.startingInterval==index && node.endingInterval==index){
                node.data=value;
                return node.data;
            }
            else {
                int leftAns=update(node.left,index,value);
                int rightAns=update(node.right,index,value);
                node.data=leftAns+rightAns;
                return node.data;
            }
        }

        else {
            return node.data;
        }

    }
}
