package leetcode.amazon.LinkedList;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=new ListNode(-1);
        ListNode res = head;
        ListNode cur1= l1,cur2=l2;

        while( cur1 != null && cur2 != null ){
            if(cur1.val<=cur2.val){
                res.next =cur1;
                cur1= cur1.next;
            }else{
                res.next =cur2;
                cur2= cur2.next;
            }
            res = res.next;
        }

        //if l1 is left
        res.next = cur1 ==null?cur2:cur1;

        return head.next;
    }
}
