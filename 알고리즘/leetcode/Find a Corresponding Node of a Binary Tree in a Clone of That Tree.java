 /*
  * About
  *
  * Author: minzzang@GitHub (minjjang1117@gmail.com)
  * Date  : 2021-01-15
  * URL   : https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree
  *
  */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    static TreeNode T;
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        T = null;
        inOrder(cloned, target.val);    
        return T;
    }
    
    private void inOrder(TreeNode cloned, int value) {
        if (cloned == null || T != null) return;
        if (cloned.val == value) {
            T = cloned;
            return;
        }
        
        inOrder(cloned.left, value);
        inOrder(cloned.right, value);
    }
}