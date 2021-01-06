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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        
        ListNode head = null;
        ListNode iterNode = null;
        
        while(l1 != null && l2 != null) {
            
            if (l1.val < l2.val) {
                if(head == null) {
                    head = new ListNode(l1.val);
                    iterNode = head;
                }
                else {
                    iterNode.next = new ListNode(l1.val);
                    iterNode = iterNode.next;
                }
                l1 = l1.next;
            }
            else {
                if (head == null) {
                    head = new ListNode(l2.val);
                    iterNode = head;
                }
                else {
                    iterNode.next = new ListNode(l2.val);
                    iterNode = iterNode.next;
                }
                l2 = l2.next;
            }
        }
        
        while(l1 != null){
            if(iterNode == null){
                head = new ListNode(l1.val);
                iterNode = head;
            }
            else{
                iterNode.next = new ListNode(l1.val);
                iterNode = iterNode.next;                
            }
            l1 = l1.next;
        }
        
        while(l2 != null){
            if(iterNode == null){
                head = new ListNode(l2.val);
                iterNode = head;
            }
            else{
                iterNode.next = new ListNode(l2.val);
                iterNode = iterNode.next;                
            }
            l2 = l2.next;
        }
        return head;
    }
}