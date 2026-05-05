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

        // Count the length
        ListNode temp = head;
        int length = 1;
        while (temp.next != null) {
            temp = temp.next;
            length++;
        }

        // Make it circular
        temp.next = head;

        // Find new tail: (length - k % length - 1)
        // and new head: (length - k % length)
        k = k % length;
        int stepsToNewHead = length - k;
        ListNode newTail = temp;
        while (stepsToNewHead-- > 0) {
            newTail = newTail.next;
        }

        // Break the loop
        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
