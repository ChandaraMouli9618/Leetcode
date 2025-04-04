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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;

        Queue<ListNode> queue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for(ListNode node : lists){
            if(node != null) queue.add(node);
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode head = dummyHead;
        
        while(!queue.isEmpty()){
            ListNode currTop = queue.poll();
            if(currTop.next != null) queue.add(currTop.next);
            head.next = currTop;
            head = currTop;
        }

        return dummyHead.next;
    }
}