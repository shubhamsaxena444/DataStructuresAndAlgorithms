package leetcode.amazon.LinkedList;

public class MergeKSortedList {
    public ListNode mergeKLists(ListNode[] lists) {
        int k = lists.length;
        return merge(lists,0,k-1);
    }
    public ListNode merge(ListNode[] l,int s,int e){
        if(e==s){
            return l[s];
        }else if(e<s){
            return null;
        }
        int m = s+(e-s)/2;
        ListNode left = merge(l,s,m);
        ListNode right = merge(l,m+1,e);
        return mergeTwoLists(left,right);
        // merge(l,s+1,e-1,res);
    }

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
