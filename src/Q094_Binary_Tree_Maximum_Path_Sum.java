
public class Q094_Binary_Tree_Maximum_Path_Sum {
	// by ninechapter && Jackie
	private int maxPath = Integer.MIN_VALUE; 
    
    public int maxPathSum(TreeNode root) {
        // write your code here
        if(root == null){
            return 0;
        }
        maxPathHelper(root);
        return maxPath;
    }
    
    public int maxPathHelper(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftPath = maxPathHelper(node.left);
        int rightPath = maxPathHelper(node.right);
        maxPath = Math.max(maxPath, leftPath + node.val + rightPath);
        return Math.max(0, Math.max(leftPath, rightPath) + node.val);  // 路径为负数，则表示为0
    }
    
    
    public static void main(String[] args){
    	Q094_Binary_Tree_Maximum_Path_Sum t = new Q094_Binary_Tree_Maximum_Path_Sum();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(-5);
    	root.right = new TreeNode(-6);
    	System.out.println(t.maxPathSum(root));
    }
}
