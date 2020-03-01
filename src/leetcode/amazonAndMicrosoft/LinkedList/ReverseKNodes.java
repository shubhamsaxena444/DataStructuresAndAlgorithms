package leetcode.amazonAndMicrosoft.LinkedList;

public class ReverseKNodes {
    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode cur = head, next = head, prev = null;
        int i = 0;
        while (i < k) {
            //return if k>length of ll
            if (next == null)
                return head;
            next = next.next;
            i++;
        }
        i = 0;

        //reverse k nodes
        while (i < k) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            i++;
        }
        //after reversal , cur and head are pointing to tail i.e kth node, and prev is pointing to head
        head.next = reverseKGroup(cur, k);
        return prev;
    }
}
