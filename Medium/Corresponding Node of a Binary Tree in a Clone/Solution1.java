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
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        return find(cloned, target.val);
    }
    
    public TreeNode find(TreeNode cloned, int value) {
        if (cloned == null) return null;
        if (cloned.val == value) return cloned;
        TreeNode lAns = find(cloned.left, value);
        TreeNode rAns = find(cloned.right, value);
        return lAns == null ? rAns : lAns;
    }
}