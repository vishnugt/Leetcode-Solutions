class Solution {
    public Node findRoot(List<Node> tree) {
        
        int value = 0;
        for(Node node : tree) {
            value ^= node.val;
            for(Node childNode : node.children) 
                value ^= childNode.val;
        }
        
        for(Node node : tree)
            if(value == node.val)
                return node;
        
        return null;
    }
}