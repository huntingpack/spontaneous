package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class LC102_BinaryTreeLevelOrder {
    public static void main(String[] s){

    }

    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }

    void dfs(TreeNode root, List<List<Integer>> res, int level){
        if(root==null)return;
        // initially level is 0 and size will be zero
        // next when level is 1 size will be 1 so we always add a list for each level
        // before adding any values at that level
        if(res.size()==level){
            res.add(new LinkedList<Integer>());
        }
        res.get(level).add(root.val);

        dfs(root.left, res, level+1);
        dfs(root.right, res, level+1);
    }
}
