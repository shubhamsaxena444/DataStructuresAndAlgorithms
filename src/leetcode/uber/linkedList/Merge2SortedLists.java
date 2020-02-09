package leetcode.uber.linkedList;
/*Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4*/
public class Merge2SortedLists {
     class ListNode {
     int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2==null)
            return null;
        if(l1==null)
            return l2;
        if(l2==null)
            return l1;

        ListNode cur1 = l1;
        ListNode cur2 = l2;
        ListNode head;


        if(cur1.val <= cur2.val){
            head = cur1;
            cur1 = cur1.next;
        }else{
            head = cur2;
            cur2 =cur2.next;
        }
        ListNode cur = head;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur1 =cur1.next;
                cur = cur.next;
            }else{
                cur.next = cur2;
                cur2 =cur2.next;
                cur = cur.next;

            }
        }
        while(cur1 !=null){
            cur.next = cur1;
            cur1 =cur1.next;
            cur = cur.next;
        }

        while(cur2 !=null){
            cur.next = cur2;
            cur2 =cur2.next;
            cur = cur.next;
        }

        return head;

    }
}
