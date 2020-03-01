package leetcode.amazonAndMicrosoft.LinkedList;
/*You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Example:

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
Explanation: 342 + 465 = 807.*/
public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head;
        ListNode tail;
        int sum =0;
        int carry =0;
        ListNode cur1=l1, cur2=l2;
        if(l1 == null && l2 ==null){
            return null;
        }else if(l1 == null){
            return l2;
        }else if (l2 ==null){
            return l1;
        }else{
            //find the bigger ll
            int n =0,m=0;
            while(cur1 != null){
                n++;
                cur1=cur1.next;
            }
            while(cur2 != null){
                m++;
                cur2=cur2.next;
            }
            //making cur2 the bigger
            if(m<n){
                cur1=l2;
                cur2 = l1;
            }else{
                cur1 = l1;
                cur2=l2;
            }
            tail =null;
            head = cur2;

            while(cur1 != null && cur2 !=null){
                sum = cur1.val + cur2.val + carry;
                carry = sum /10;
                sum = sum%10;

                cur2.val = sum;

                tail =cur2;
                cur1= cur1.next;
                cur2= cur2.next;

            }

            while(cur2 != null){
                sum = cur2.val  + carry;
                carry = sum /10;
                sum = sum%10;

                tail =cur2;
                cur2.val = sum;
                cur2= cur2.next;
                // res = res.next;
            }
            if(carry!=0){
                tail.next = new ListNode(carry);
            }
        }
        return head;
    }
}
