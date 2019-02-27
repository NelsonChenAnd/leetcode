package leetcode.list;

/**
 * Author: SJ
 * Date: 2019/2/17
 */
public class SortList_148 {

    public static void main(String[] args) {
        SortList_148 a = new SortList_148();
        ListNode head=new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);
        a.sortList(head);

    }

    public ListNode sortList(ListNode head) {
        if(head==null) {
            return null;
        }
        if(head.next==null) {
            return head;
        }
        ListNode prev = null, slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            fast=fast.next.next;
            prev=slow;
            slow=slow.next;
        }
        ListNode head2 = slow;
        prev.next=null;
        ListNode newHead1 = sortList(head);
        ListNode newHead2 = sortList(head2);
        ListNode newHead = merge(newHead1, newHead2);
        return newHead;
    }

    private ListNode merge(ListNode head1, ListNode head2) {
        if(head1==null) {
            return head2;
        }
        if(head2==null) {
            return head1;
        }
        ListNode p1=head1, p2=head2;
        ListNode headNode = new ListNode(-1), p=headNode;
        while(head1!=null && head2!=null) {
            if(head1.val<head2.val) {
                p.next=head1;
                head1=head1.next;
            } else {
                p.next=head2;
                head2=head2.next;
            }
            p=p.next;
            p.next=null;
        }
        if(head1!=null) {
            p.next=head1;
        }
        if(head2!=null) {
            p.next=head2;
        }

        return headNode.next;
    }

}
class ListNode {
    public int val;
    public ListNode next=null;
    public ListNode(int val) {
        this.val = val;
    }
}
