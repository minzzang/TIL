 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-15
  * URL   : https://leetcode.com/problems/merge-two-sorted-lists
  *
  */

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
        if (l1 == null && l2 == null) return null;
        else if (l1 == null && l2 != null) return l2;
        else if (l1 != null && l2 == null) return l1;
        
        ListNode head = new ListNode();
        ListNode nextNode = new ListNode();
        head.next = nextNode;
        
        while (l1 != null && l2 != null) {
            
            if (l1.val >= l2.val) {
                nextNode.next = l2;
                l2 = l2.next;
            } else {
                nextNode.next = l1;
                l1 = l1.next;
            }
            
            nextNode = nextNode.next;
        }
        
        if (l1 == null) {
            nextNode.next = l2;
        } else {
            nextNode.next = l1;
        }
        
        return head.next.next;
    }
}