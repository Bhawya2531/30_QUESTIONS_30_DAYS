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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        int L=1;
        ListNode tail=head;
        while(tail.next!=null){
            tail=tail.next;
            L++;
        }
        k=k%L;
        if(k==0){
            return head;
        }
        tail.next=head; //circular connect (tail will now point to head cuz there gonna be a new head)
         //L-K
         int remain=L-k;
         ListNode newTail=head;
         for(int c=1;c<remain;c++){
            newTail=newTail.next;
         }
         ListNode newhead=newTail.next;
         newTail.next=null;
         return newhead;
    }
}
