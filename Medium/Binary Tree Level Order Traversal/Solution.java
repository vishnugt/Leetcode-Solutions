//Using queue
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levels = new ArrayList();
    
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> currentLevelList = new ArrayList<Integer>();
            
            for(int i = 0, size = queue.size(); i < size; ++i) {
                TreeNode node = queue.remove();
                if(node == null) continue;
                currentLevelList.add(node.val);
                if(node.left != null) queue.add(node.left);
                if(node.right != null)queue.add(node.right);
            }
            
            if(!currentLevelList.isEmpty()) levels.add(currentLevelList);
        }
        return levels;
    }
}


//Without queue
class Solution {
    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

         // fulfil the current level
         levels.get(level).add(node.val);

         // process child nodes for the next level
         if (node.left != null)
            helper(node.left, level + 1);
         if (node.right != null)
            helper(node.right, level + 1);
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return levels;
        helper(root, 0);
        return levels;
    }
}