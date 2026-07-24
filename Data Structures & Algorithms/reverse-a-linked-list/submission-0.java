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
    public ListNode reverseList(ListNode head) {
        ListNode p1=null;
        ListNode p2=head;
        ListNode temp;
        while(p2!=null){
            temp=p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
        }
        return p1;
    }
}
