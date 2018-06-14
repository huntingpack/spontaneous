package linkedlists;

/**
 * https://leetcode.com/problems/rotate-list/description/
 */
public class LC61_RotateList {

    static class ListNode{
        ListNode next;
        int val;
        ListNode(int val){
            this.val = val;
        }

        public String toString(){
            StringBuilder sb = new StringBuilder();
            ListNode c = this;
            while(c!=null){
                if(sb.length() > 0){
                    sb.append(",");
                }
                sb.append(c.val);
                c = c.next;
            }
            return sb.toString();
        }
    }

    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)return head;

        //find len
        ListNode tail = head;
        int len = 1;
        while(tail.next !=null){
            len++;
            tail = tail.next;
        }

        k = k%len;// find how many times to rotate relative to len
        if(k==0)return head;// if k is a multiple of len then we don't need to rotate as rotation will lead to the same LL we have now

        // join the tail to head
        tail.next = head;

        // now need to traverse the LL 'n-k' times so that we detach the circular LL i.e.
        // in the example below we detach '2'. so move 5-3=2 times
        // Ex: 1->2->3->4->5, k=3
        // Output:  3->4->5->1->2

        for(int i=0;i<len-k;i++){
            tail = tail.next;
        }

        // now tail will be pointing the pos that needs to be detached
        ListNode newHead = tail.next;
        tail.next=null;
        return newHead;
    }

    public static void main(String[] s){
        ListNode head = new ListNode(1);
        ListNode t = head;
        head.next=new ListNode(2);
        head=head.next;
        head.next = new ListNode(3);
        head=head.next;
        head.next=new ListNode(4);
        head=head.next;
        head.next=new ListNode(5);
        System.out.println(new LC61_RotateList().rotateRight(t,2));
    }
}
