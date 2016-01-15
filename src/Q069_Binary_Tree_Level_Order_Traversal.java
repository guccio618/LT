import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;


public class Q069_Binary_Tree_Level_Order_Traversal {
	// by Jackie
	public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        // write your code here
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if(root == null){
            return res;
        }
        ArrayList<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.add(root);
        int num = 1;
        
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left != null)
                q.add(node.left);
            if(node.right != null)
                q.add(node.right);
            if(--num == 0){
                res.add(new ArrayList<Integer>(list));
                list.clear();
                num = q.size();
            }
        }
        return res;
    }
}
