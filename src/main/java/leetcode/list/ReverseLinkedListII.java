package leetcode.list;

/**
 * Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */

public class ReverseLinkedListII {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        int delta = n-m;

        if(delta<=0) {
            return head;
        }

        ListNode headNode = new ListNode(-1);
        headNode.next = head;
        ListNode pre = headNode;
        ListNode p = head, q = head;

        // q先走delta步。
        while(delta--!=0 && q!=null) {
            q=q.next;
        }
        if(q==null){
            return null;
        }

        int count=1;
        // p、q同时向前走m步。
        while(count<m) {
            pre=p;
            p=p.next;
            q=q.next;
            count++;
        }

        // reverse p和q之间的节点
        while(p!=q) {
            p.next=q.next;
            q.next=p;
            p=p.next;
        }
        pre.next=p;
        return head;
    }
}
