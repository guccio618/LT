
public class Q115_Minimum_Depth_of_Binary_Tree {
	// by Jackie
	public int minDepth(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        return helper(root, 1);
    }
    
    public int helper(TreeNode node, int level){
        if(node.left == null && node.right == null){
            return level;
        }
        int minDepth = Integer.MAX_VALUE;
        if(node.left != null){
            minDepth = Math.min(minDepth, helper(node.left, level+1)); 
        }
        if(node.right != null){
            minDepth = Math.min(minDepth, helper(node.right, level+1)); 
        }
        return minDepth;
    }
}
