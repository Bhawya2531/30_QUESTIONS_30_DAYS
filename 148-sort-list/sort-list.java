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
    public ListNode sortList(ListNode head) {
        if(head==null) return null;
        List<Integer>arr=new ArrayList<>();
        ListNode curr=head;
        while(curr!=null){
            arr.add(curr.val);
            curr=curr.next;
        }
        Collections.sort(arr);
        curr=head;
        int i=0;
        while(curr!=null){
            curr.val=arr.get(i++);
            curr=curr.next;
        }
        return head;
    }
}
        