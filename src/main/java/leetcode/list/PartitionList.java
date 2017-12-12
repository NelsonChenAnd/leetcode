package leetcode.list;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come
 * before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * For example,
 * Given 1->4->3->2->5->2 and x = 3,
 * return 1->2->2->4->3->5.
 *
 * 给定一个链表和一个值，切分列表使得所有比x 小的节点 在所有>=x 的节点前面，
 * 要求在两个list 分片中保持节点的原始相对顺序。
 */

public class PartitionList {

    public static void main(String[] args) {
        PartitionList p = new PartitionList();
        ListNode head = p.new ListNode(1);
        int x=0;
        ListNode res = p.partition(head, x);
        while(res!=null) {
            System.out.println(res.val);
            res=res.next;
        }
    }
    // headNode -> 2 -> 1
    public ListNode partition(ListNode head, int x) {

        ListNode headNode = new ListNode(Integer.MIN_VALUE);
        headNode.next=head;
        ListNode pre=headNode, p=headNode.next;

        while(p!=null) {
            if(p.val<x) {
                pre=p;
                p=p.next;
            } else { // 1. 一定要记得break 否则就死循环了！！！
                break;
            }
        }

        ListNode pre2 = pre, tail=null;
        while(p!=null) {
            if(p.val>=x) {
                pre2=p;
                p=p.next;
            } else {
                tail=p.next;
                pre2.next=tail;
                p.next=pre.next;
                pre.next=p;
                p=tail;
                pre=pre.next;
            }
        }
        return headNode.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
