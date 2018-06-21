package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by spuvvada on 20/06/18.
 */
public class LC103_BinaryTreeZigZagLevelOrder {

    public static void main(String[] s){

    }

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    void helper(TreeNode root, List<List<Integer>> res, int level){
        if(root == null)return;

        if(res.size()==level){
            res.add(new LinkedList<Integer>());
        }

        if(level%2==0){
            res.get(level).add(root.val);
        }
        else{
            res.get(level).add(0, root.val);
        }
        helper(root.left, res, level+1);
        helper(root.right, res, level+1);
    }
}
