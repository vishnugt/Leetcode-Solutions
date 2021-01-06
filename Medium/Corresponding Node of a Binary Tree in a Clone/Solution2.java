class Solution {
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original == null)
            return null;
        
        if(original == target) {
            return cloned;
        }
        
        TreeNode lNode = getTargetCopy(original.left, cloned.left, target);
        TreeNode rNode = getTargetCopy(original.right, cloned.right, target);
        return lNode == null ? rNode : lNode;
    }

}