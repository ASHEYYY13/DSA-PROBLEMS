package Linked_List.Problems;

/*
1.SortList,getMidInDifferentWay,
2.FindingMiddleNode
3.MergeTwoSortedList
3.ReOrder the LL
4.rotateRight LL
5/getSize
 */
public class mergeTwoList {
   private ListNode head;
   private ListNode tail;
private int size;

    public mergeTwoList() {
        this.size=0;
    }
    public void insertFirst(int value){
        ListNode listNode =new ListNode(value);
        listNode.next=head;
        head= listNode;
        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    public void add(int value){
        if(tail==null){
            insertFirst(value);
            return;
        }
        ListNode listNode =new ListNode(value);
        tail.next= listNode;
        tail= listNode;

        size+=1;
    }

    public void display(){
       ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
//        System.out.print("END");
        System.out.println();
    }

 static    class ListNode {
      private   int val;
       private ListNode next;

        public ListNode() {
        }

        public ListNode(int value) {
            this.val = value;
        }

        public ListNode(ListNode next, int value) {
            this.val = value;
            this.next = next;
        }
    }

    //Reorder linked list
   static   public void reorderList(ListNode head) {
        if(head==null || head.next==null){
            return;
        }
        ListNode firstHead=head;
        ListNode ans=firstHead;
      ListNode mid=middleNode(head);
      ListNode reverseHead=reverse(mid);
      while (firstHead!=null && reverseHead!=null){
          ListNode temp=firstHead.next;
          firstHead.next=reverseHead;
          firstHead=temp;
          temp=reverseHead.next;
          reverseHead.next=firstHead;
          reverseHead=temp;
      }
      //everything is arranged
         //just adding tail.next=null
    if(firstHead!=null){
        firstHead.next=null;
    }
  displayWithHead(ans);
    }

    static ListNode reverse(ListNode head){
        ListNode temp=head;
        ListNode prev=null;
        while (temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }

   static void displayWithHead(ListNode head){
        ListNode temp=head;
        while (temp!=null){
            System.out.print(temp.val+" -> ");
            temp=temp.next;
        }
        System.out.print("END");
    }
//merge two sorted Linked List
    public static void main(String[] args) {
         mergeTwoList list1=new mergeTwoList();

         list1.add(1);
         list1.add(3);
         list1.add(5);

        mergeTwoList list2=new mergeTwoList();
         list2.add(2);
         list2.add(6);
         list2.add(8);
         list2.add(3);
         list2.add(5);
         list2.add(9);
//         reverseKGroups(list2.head,2);
//          reorderList(list2.head);
        rotateRight(list2.head,2);
//         list1.display();
//         list2.display();
//       mergeTwoList ans= mergeTwo(list1,list2);
//       ans.display();

    }

    public ListNode sortList(ListNode head) {
          if(head==null || head.next==null){
              return head;
          }
         ListNode mid=middleNode(head);
          ListNode left=sortList(head);
          ListNode right=sortList(mid);

          return merge(left,right);


    }

 ListNode merge(ListNode list, ListNode list2){

        ListNode ans=new ListNode();
        ListNode tail=ans;
        while (list!=null && list2!=null){
            if(list.val<list2.val){
                tail.next=list;
                list=list.next;
                tail=tail.next;
            }
            else {
                tail.next=list2;
                list2=list2.next;
                tail=tail.next;
            }
        }
        while (list2!=null){
            tail.next=list;
            list2=list2.next;
            tail=tail.next;
        }
        while (list!=null){
          tail.next=list;
            list=list.next;
            tail=tail.next;
        }
        return ans.next;
    }


    static mergeTwoList mergeTwo(mergeTwoList list, mergeTwoList list2){
        ListNode temp1=list.head;
        ListNode temp2=list2.head;

    mergeTwoList ans=new mergeTwoList();
        while (temp1!=null && temp2!=null){
            if(temp1.val>temp2.val){
                ans.add(temp2.val);
                temp2=temp2.next;
            }
            else {
                ans.add(temp1.val);
                temp1=temp1.next;
            }
        }
        while (temp1!=null){ans.add(temp1.val);
            temp1=temp1.next;
        }
        while (temp2!=null){
            ans.add(temp2.val);
            temp2=temp2.next;
        }
   return ans;
    }

   static public ListNode middleNode(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        if(fast==null){
            return fast;
        }
        while( fast!=null &&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }

    public ListNode getMid(ListNode head){
        ListNode midprev=null;
        while(head!=null && head.next!=null){
            midprev=(midprev==null)?head:midprev.next;
            head=head.next.next;
        }
        ListNode mid=midprev.next;
        midprev.next=null;
        return mid;
    }
//will finish this later
    static ListNode reverseKGroups(ListNode head, int k){
        if (k==0 || k==1  || head==null){
            return head;
        }
        ListNode temp=head;
        ListNode previous=null;

        while (temp!=null) {
            ListNode last = previous;
            ListNode newEnd = temp;
            for (int i = 0; temp != null && i < k; i++) {
                ListNode front = temp.next;
                temp.next = previous;
                previous = temp;
                temp = front;
            }
            if (last != null) {
                last.next = previous;
            } else {
                head = previous;
            }

        }
        displayWithHead(head);
        return head;
    }

   static public ListNode rotateRight(ListNode head, int k) {
        if(k<=0 || head==null || head.next==null){
            return head;
        }
        int size=getSize(head);
       int rotate=k%size;
       ListNode temp=head;
       for (int i = 1; i <size-rotate ; i++) {
           temp=temp.next;
       }
       ListNode newTail=temp;
       ListNode newHead=temp.next;
       for (int i = 0; i <2 ; i++) {
           temp=temp.next;
       }
       newTail.next=null;
       temp.next=head;
       head=newHead;
       displayWithHead(newHead);
       return newHead;

    }
    static int getSize(ListNode head){
        ListNode temp=head;
      int count=0;
      while (temp!=null){
          count++;
          temp=temp.next;
      }
      return count;
    }
}
