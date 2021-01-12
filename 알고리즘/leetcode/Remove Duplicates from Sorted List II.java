 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-12
  * URL   : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii
  *
  */

/*
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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        
        int[] values = new int[201]; 
        
        while (head.next != null) {
            int value = head.val;
            head = head.next;
            
            values[value + 100]++;
        }
        values[head.val + 100]++;
        
        
        List<ListNode> list = new ArrayList<>();
        for (int i = 0; i < values.length; i++) {
            if (values[i] == 1) {
                list.add(new ListNode(i - 100));
            }
                
        }
        
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i+1);
        }
        
        return new ListNode(list.get(0).val, list.get(0).next);
        
    }
}