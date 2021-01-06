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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> multiLeaves = new ArrayList();
        while(root!=null){
            List<Integer> temp = new ArrayList<Integer>();
            root = collectLeaves(root, temp);
            multiLeaves.add(temp);
        }
        return multiLeaves;
    }
    
    public TreeNode collectLeaves(TreeNode root, List<Integer> leavesList) {
        if(root == null) 
            return root;
        
        if(root.left == null && root.right == null) {
            leavesList.add(root.val);
            return null;
        }
        
        root.left = collectLeaves(root.left, leavesList);
        root.right = collectLeaves(root.right, leavesList);
        
        return root;
    }
}