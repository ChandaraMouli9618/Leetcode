/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);

        int carry = 0;
        ListNode dummyAns = new ListNode(-1);
        ListNode ansHead = dummyAns;

        while(l1 != null && l2 != null){
            int currAns = l1.val + l2.val + carry;
            carry = currAns / 10;
            int currVal = currAns % 10;
            ansHead.next = new ListNode(currVal);
            ansHead = ansHead.next;
            l2 = l2.next;
            l1 = l1.next;
        }

        while(l1 != null){
            int currAns = l1.val + carry;
            carry = currAns / 10;
            int currVal = currAns % 10;
            ansHead.next = new ListNode(currVal);
            ansHead = ansHead.next;
            l1 = l1.next;
        }

        while(l2 != null){
            int currAns = l2.val + carry;
            carry = currAns / 10;
            int currVal = currAns % 10;
            ansHead.next = new ListNode(currVal);
            ansHead = ansHead.next;
            l2 = l2.next;
        }

        if(carry > 0) ansHead.next = new ListNode(carry);
        dummyAns = dummyAns.next;

        return reverseList(dummyAns);
    }


    ListNode reverseList(ListNode root){
        if(root == null) return null;

        ListNode prev = null;
        ListNode curr = root;
        ListNode next = root.next;

        while(curr != null){
            curr.next = prev;
            prev = curr;
            curr = next;
            if(next != null) next = next.next;
        }

        return prev;
    }
}