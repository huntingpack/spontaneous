package trees;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaxDepthBinaryTree {
    public static void main(String[] s){

    }

    public int maxDepth(TreeNode root) {
        if(root==null)return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public int maxDepthIterative(TreeNode root) {
        if(root==null)return 0;
        // do level order traversal
        // the last level will b the ans !!
        Queue<TreeNode> current = new LinkedList<>();
        current.add(root);
        int level = 0; // init from zero
        while(!current.isEmpty()){
            int size = current.size();
            for(int i=0; i<size; i++) {
                TreeNode node = current.poll();
                if (node.left != null) {
                    current.add(node.left);
                }
                if(node.right!=null){
                    current.add(node.right);
                }
            }
            level++;
        }
        return level;
    }

}
