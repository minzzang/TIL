 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-03-08
  * URL   : https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
  *
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int sumEvenGrandparent(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Integer> nodeList = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode pick = queue.poll();
            
            nodeList.add(pick.val);
            if (pick.left != null) queue.offer(pick.left);
            if (pick.left != null) queue.offer(pick.right);
        }
        
        for (int i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i) % 2 != 0) continue;
            if ((i+1) )
        }
    }
}
