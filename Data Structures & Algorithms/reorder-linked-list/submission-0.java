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
    public void reorderList(ListNode head) {
        ListNode temp= head;
        ListNode result= head;
        while(temp!=null){
            temp.next=reverse(temp.next);
            temp=temp.next;
        }
    }
    public ListNode reverse(ListNode node){
        ListNode p1=null;
        ListNode p2=node;
        while(p2!=null){
            ListNode temp=p2.next;
            p2.next=p1;
            p1=p2;
            p2=temp;
        }
        return p1;
    }
}
